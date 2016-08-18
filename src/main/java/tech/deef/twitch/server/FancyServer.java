package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.deef.twitch.manipulation.GetLiveNames;

@WebServlet("/FancyTwitch/*")
public class FancyServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletWorker.stringOutput(this.getClass(), request, response, (String username, PrintWriter out) -> {
			String[] liveNames = GetLiveNames.getLiveNames(username);

			StringBuffer buffer = new StringBuffer();

			buffer.append("<h3>The following people " + username + " Follows are live</h3>");
			buffer.append("<p>");
			for (String s : liveNames) {
				buffer.append("<a href=\"https://www.twitch.tv/" + s + "\">" + s + "<br /> </a>");
			}
			buffer.append("</p>");
			out.write(buffer.toString());
			
		});
	}

	public void destroy() {
		// do nothing.
	}
}
