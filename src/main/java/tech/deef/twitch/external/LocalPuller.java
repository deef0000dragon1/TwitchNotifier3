package tech.deef.twitch.external;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocalPuller implements DataPull {

	public String PullData(String input) {

		// address how the urls are handled.

		String location = "";
		if (input.contains("kraken/users/")) {
			location = "files/TestFiles/UserFollowsChannels.json";
		} else if (input.contains("https://api.twitch.tv/kraken/streams/Deef0000dragon1")) {
			location = "files/TestFiles/StreamsUserOffline.json";
		} else if (input.contains("kraken/channels/")) {
			location = "files/TestFiles/ChannelsUser.json";
		} else if (input.contains("https://api.twitch.tv/kraken/streams/BobRoss")) {
			location = "files/TestFiles/StreamsUserOnline.json";
		}

		File file = new File(location);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		StringBuffer buffer = new StringBuffer();
		while (scanner.hasNextLine()) {
			buffer.append(scanner.nextLine());
		}

		return buffer.toString();
	}

}
