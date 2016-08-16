package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.deef.twitch.external.DataPull;
import tech.deef.twitch.external.DataPuller;
import tech.deef.twitch.external.TwitchAPI;
import tech.deef.twitch.external.TwitchAPIPull;
import tech.deef.twitch.manipulation.GetFollowed;
import tech.deef.twitch.manipulation.GetStreams;

@WebServlet("/Twitch/*")
public class TwitchServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.

		System.out.println("this is a thing to say that the thing was called");
		PrintWriter out = response.getWriter();

		String username = request.getPathInfo().substring(1);
		if (!username.equals("*")) {
			DataPull pull = new DataPuller();
			TwitchAPI puller = new TwitchAPIPull(pull);
			GetStreams pulling = new GetStreams(puller);
			String[] liveNames = null;
			liveNames = pulling.getLiveStreams(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));

			for (String name : liveNames) {
				out.println("<h1>" + "Live user: " + name + "</h1>");
			}
		}
	}

	public void destroy() {
		// do nothing.
	}
}
