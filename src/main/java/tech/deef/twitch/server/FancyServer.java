package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.deef.twitch.domain.Stream;
import tech.deef.twitch.manipulation.GetLiveNames;

@WebServlet("/FancyTwitch/*")
public class FancyServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletWorker.stringOutput(this.getClass(), request, response, (String username, PrintWriter out) -> {
			List<Stream> liveNames = GetLiveNames.getLiveStreams(username);

			Collections.sort(liveNames, new Comparator<Stream>() {
		        @Override
		        public int compare(Stream stream2, Stream stream1)
		        {

		            return  stream2.getChannel().getDisplayName().toLowerCase().compareTo(stream1.getChannel().getDisplayName().toLowerCase());
		        }
		    });
			
			StringBuffer buffer = new StringBuffer();

			buffer.append("<h3>The following people " + username + " Follows are live</h3>");
			buffer.append("<p>");
			for (Stream stream : liveNames) {
				buffer.append("<a href=\"https://www.twitch.tv/" + stream.getChannel().getDisplayName() + "\">" + stream.getChannel().getDisplayName() + "</a>");
				buffer.append(" - " + stream.getChannel().getGame() + "<br /> " + stream.getChannel().getStatus() + "<br /><br />");
			}
			buffer.append("</p>");
			out.write(buffer.toString());
			
		});
	}

	public void destroy() {
		// do nothing.
	}
}
