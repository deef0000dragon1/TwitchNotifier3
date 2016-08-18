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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tech.deef.twitch.manipulation.GetLiveNames;

@WebServlet("/Twitch/*")
public class TwitchServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date(System.currentTimeMillis());
		System.out.print("CALL: " + this.getClass().toString() + " was called with arguments \"" + request.getPathInfo());
		System.out.println("\" at [" + date.toString() + "]");
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		try {
			PrintWriter out = response.getWriter();

			String username = request.getPathInfo().substring(1);
			if (!username.equals("*")) {
				String[] liveNames = GetLiveNames.getLiveNames(username);

				ObjectMapper mapper = new ObjectMapper();
				ObjectNode topLevel = mapper.createObjectNode();

				ArrayNode arrayNode = mapper.createArrayNode();
				for (String s : liveNames) {
					ObjectNode object = mapper.createObjectNode();
					object.put("name", s);
					arrayNode.add(object);
				}
				
				topLevel.set("LiveUsers", arrayNode);
				out.print(topLevel.toString());
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
		System.out.print("INFO: " + this.getClass().toString() + " called with arguments \"" + request.getPathInfo());
		System.out.println("\" at [" + date.toString() + "] completed in :"
				+ (System.currentTimeMillis() - date.getTime()) + " ms");
	}

	public void destroy() {
		// do nothing.
	}
}
