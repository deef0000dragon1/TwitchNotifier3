package tech.deef.twitch.manipulation;

import java.util.ArrayList;

import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.external.TwitchAPI;

public class GetStreams {

	private TwitchAPI puller;

	public GetStreams(TwitchAPI puller) {
		this.puller = puller;
	}

	public String[] getLiveStreams(String[] streams) {
		StreamsUser user = null;
		ArrayList<String> liveUsers = new ArrayList();
		for (String testUser : streams) {
			// System.out.print("\n"+testUser);
			user = puller.getStreamsUser(testUser);
			if(user != null){if (user.getStream() != null) {
				liveUsers.add(testUser);
			}}else{
				System.out.println("ERROR: User is null in getLiveStreams. User: " + testUser);
			}
		}

		String[] live = new String[liveUsers.size()];
		for(int i = 0; i < liveUsers.size(); i++){
			live[i] = liveUsers.get(i);
		}
		
		return live;
	}
}
