package tech.deef.twitch.server;

import java.io.PrintWriter;


public interface OutputFormatLambda {
	public void operation(String user, PrintWriter out);
}
