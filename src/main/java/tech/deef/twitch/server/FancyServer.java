package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

	private final int RELOAD_TIME = 60000;
	private final int RELOAD_FAIL_TIMEOUT = 10000;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletWorker.stringOutput(this.getClass(), request, response, (String username, PrintWriter out) -> {
			List<Stream> liveNames = GetLiveNames.getLiveStreamsThreaded(username);

			Collections.sort(liveNames, new Comparator<Stream>() {
				@Override
				public int compare(Stream stream2, Stream stream1) {
					return stream2.getChannel().getDisplayName().toLowerCase()
							.compareTo(stream1.getChannel().getDisplayName().toLowerCase());
				}
			});

			StringBuffer buffer = new StringBuffer();

			buffer.append("<h3>The following people " + username + " Follows are live</h3>");
			buffer.append("<p>");
			for (Stream stream : liveNames) {
				String time = stream.getCreatedAt();
				buffer.append("<p>");
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
					Date now = new Date();
					Date then;

					then = dateFormat.parse(time);
					if (Duration.ofMillis((now.getTime() - then.getTime())).abs().getSeconds() < 3600) {
						buffer.append("<font size=\"5\" color=\"green\">");
					}

					buffer.append("<a href=\"https://www.twitch.tv/" + stream.getChannel().getDisplayName() + "\">"
							+ stream.getChannel().getDisplayName() + "</a>");
					buffer.append(" - " + stream.getChannel().getGame() + "<br /> " + stream.getChannel().getStatus()
							+ "<br />");

					Duration liveTime = Duration.ofMillis((now.getTime() - then.getTime())).abs();
					if (Duration.ofMillis((now.getTime() - then.getTime())).abs().getSeconds() < 3600) {
						buffer.append("Live for: " + "" + liveTime.toDays() + "d " + liveTime.toHours() % 24 + ":"
								+ liveTime.toMinutes() % 60 + ":" + liveTime.getSeconds() % 60 + "<br />");
					}else
					{
						buffer.append("<font size=\"2\" color=\"red\">Live for: " + "" + liveTime.toDays() + "d "
								+ liveTime.toHours() % 24 + ":" + liveTime.toMinutes() % 60 + ":"
								+ liveTime.getSeconds() % 60 + "<br />");
					}

					buffer.append("Viewers: " + stream.getViewers() + "</font>");

					buffer.append("<br />");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR: Time parse failure. Time: " + time);
					e.printStackTrace();
					;
				}
				buffer.append("</p>");
			}
			buffer.append("</p>");
			buffer.append("<script>setTimeout(function(){"
					+ "window.location.reload(true);setTimeout(function(){alert(\"ReloadFailed\");},"
					+ RELOAD_FAIL_TIMEOUT + ")},(" + RELOAD_TIME + "))</script>");
			out.write(buffer.toString());

		});
	}

	public void destroy() {
		// do nothing.
	}
}
