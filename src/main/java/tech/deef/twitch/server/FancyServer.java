package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import tech.deef.twitch.external.DataPull;
import tech.deef.twitch.external.DataPuller;
import tech.deef.twitch.external.TwitchAPI;
import tech.deef.twitch.external.TwitchAPIPull;
import tech.deef.twitch.manipulation.GetFollowed;
import tech.deef.twitch.manipulation.GetStreams;

@WebServlet("/FancyTwitch/*")
public class FancyServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.

		try {
			Date date = new Date(System.currentTimeMillis());
			System.out.print("CALL: FacnyServer was called with arguments \"" + request.getPathInfo());
			System.out.println("\" at [" + date.toString() + "]");

			PrintWriter out = response.getWriter();

			String username = request.getPathInfo().substring(1);
			if (!username.equals("*")) {
				DataPull pull = new DataPuller();
				TwitchAPI puller = new TwitchAPIPull(pull);
				GetStreams pulling = new GetStreams(puller);
				String[] liveNames = null;
				liveNames = pulling.getLiveStreams(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));

				System.out.println("INFO: The Number of people live: " + liveNames.length);

				
				out.write("<h3>The following people " + username + " Follows are live</h3>");
				out.write("<p>");
				for(String s: liveNames){
					out.write("<a href=\"https://www.twitch.tv/" + s + "\">" + s + "<br /> </a>");
				}
				out.write("</p>");
				
				
				//TODO: change the mapper to use a full json format. THis may include making another DOMAIN object
				
				//{deef,person,name,geoff,spike}
			}
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("an error occured");
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.out.println();
			e.printStackTrace(System.out);

			PrintWriter out = response.getWriter();
			out.println("<p> we apologize, but an error has occured. Please contact the administrator at"
					+ "deef551@gmail.com for more assistance </p>");
		}
	}

	public void destroy() {
		// do nothing.
	}
}