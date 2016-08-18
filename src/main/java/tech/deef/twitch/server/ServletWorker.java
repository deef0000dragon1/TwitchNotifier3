package tech.deef.twitch.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWorker {

	public static void stringOutput(Class parent, HttpServletRequest request, HttpServletResponse response, OutputFormatLambda lambda) throws IOException{
		
		Date date = new Date(System.currentTimeMillis());
		System.out.println("CALL: " + parent.toString() 
		+ " was called from " + request.getRemoteAddr() 
		+ " at [" + date.toString() 
		+ "] with arguments \"" + request.getPathInfo() + "\" ");
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		try {
			PrintWriter out = response.getWriter();

			String username = request.getPathInfo().substring(1);
			if (!username.equals("*")) {
				lambda.operation(username, out);
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
		System.out.println("INFO: " + parent.toString() 
		+ " was called from " + request.getRemoteAddr() 
		+ " at [" + date.toString() 
		+ "] with arguments \"" + request.getPathInfo() + "\" completed in :"
		+ (System.currentTimeMillis() - date.getTime()) + " ms");
	
	}
}
