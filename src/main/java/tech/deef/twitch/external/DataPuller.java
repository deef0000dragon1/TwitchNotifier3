package tech.deef.twitch.external;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DataPuller implements DataPull{

	private final String KEY;
	
	
	
	public DataPuller(){
		Scanner scanner = null;
		/*try {
			scanner = new Scanner(new File("TwitchServer/Files/keys/key"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//KEY = scanner.nextLine();
		KEY = "4eiyeqowhki5vtmbwcdgk74h3b0l260";
	}
	
	
	
	public String PullData(String link) {

		URL url;
		InputStream inputStream = null;
		BufferedReader bufferedReader;
		String data = null;
		
		try {
			url = new URL(link);
			URLConnection c = url.openConnection();
			c.setRequestProperty("Client-ID", KEY);
			
			inputStream = c.getInputStream(); // throws an IOException
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			
			data = bufferedReader.readLine();
			
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			//ioe.printStackTrace();
			System.out.println("ERROR: IO Exception in Data Puller");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		
		return data;
	}

}
