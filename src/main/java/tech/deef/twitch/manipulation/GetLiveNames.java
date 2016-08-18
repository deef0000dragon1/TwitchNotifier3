package tech.deef.twitch.manipulation;

import java.util.ArrayList;

import tech.deef.twitch.domain.Stream;
import tech.deef.twitch.external.DataPull;
import tech.deef.twitch.external.DataPuller;
import tech.deef.twitch.external.TwitchAPI;
import tech.deef.twitch.external.TwitchAPIPull;

public class GetLiveNames {
	//Returns an array of names that are all of the live users followed by username
	public static String[] getLiveNames(String username){
		DataPull pull = new DataPuller();
		TwitchAPI puller = new TwitchAPIPull(pull);
		GetStreams pulling = new GetStreams(puller);
		String[] liveNames = null;
		liveNames = pulling.getLiveStreamsNames(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));
		System.out.println("INFO: The Number of people live: " + liveNames.length);
		return liveNames;
	}
	
	//returns an arraylist of Stream POJOs of all live users followed by username
	public static ArrayList<Stream> getLiveStreams(String username){
		DataPull pull = new DataPuller();
		TwitchAPI puller = new TwitchAPIPull(pull);
		GetStreams pulling = new GetStreams(puller);
		ArrayList<Stream> liveNames = new ArrayList<Stream>();
		liveNames = pulling.getLiveStreams(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));
		System.out.println("INFO: The Number of people live: " + liveNames.size());
		return liveNames;
	}
}
