package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tech.deef.twitch.manipulation.GetLiveNames;

@WebServlet("/JSONTwitch/*")
public class TwitchServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletWorker.stringOutput(this.getClass(), request, response, (String username, PrintWriter out) -> {

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
			
		});
	}

	public void destroy() {
		// do nothing.
	}
}

/*
 * 
 * 
 * String[] liveNames = GetLiveNames.getLiveNames(username);
 * 
 * StringBuffer buffer = new StringBuffer();
 * 
 * buffer.append("<h3>The following people " + username +
 * " Follows are live</h3>"); buffer.append("<p>"); for (String s : liveNames) {
 * buffer.append("<a href=\"https://www.twitch.tv/" + s + "\">" + s +
 * "<br /> </a>"); } buffer.append("</p>");
 * 
 * out.write(buffer.toString());
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */