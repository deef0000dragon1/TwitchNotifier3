package tech.deef.twitch.manipulation;

import tech.deef.twitch.external.DataPull;
import tech.deef.twitch.external.DataPuller;
import tech.deef.twitch.external.TwitchAPI;
import tech.deef.twitch.external.TwitchAPIPull;

public class GetLiveNames {
	public static String[] getLiveNames(String username){
		DataPull pull = new DataPuller();
		TwitchAPI puller = new TwitchAPIPull(pull);
		GetStreams pulling = new GetStreams(puller);
		String[] liveNames = null;
		liveNames = pulling.getLiveStreams(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));
		System.out.println("INFO: The Number of people live: " + liveNames.length);
		return liveNames;
	}
}
