package tech.deef.twitch.manipulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import tech.deef.twitch.domain.Stream;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.external.TwitchAPI;

public class GetStreams {

	private TwitchAPI puller;

	public GetStreams(TwitchAPI puller) {
		this.puller = puller;
	}

	public String[] getLiveStreamsNames(String[] streams) {
		StreamsUser user = null;
		ArrayList<String> liveUsers = new ArrayList();
		for (String testUser : streams) {
			// System.out.print("\n"+testUser);
			user = puller.getStreamsUser(testUser);
			if (user != null) {
				if (user.getStream() != null) {
					liveUsers.add(testUser);
				}
			} else {
				System.out.println("ERROR: User is null in getLiveStreams. User: " + testUser);
			}
		}

		String[] live = new String[liveUsers.size()];
		for (int i = 0; i < liveUsers.size(); i++) {
			live[i] = liveUsers.get(i);
		}

		return live;
	}

	public ArrayList<Stream> getLiveStreams(String[] streams) {
		StreamsUser user = null;
		ArrayList<Stream> liveUsers = new ArrayList();
		for (String testUser : streams) {
			// System.out.print("\n"+testUser);
			user = puller.getStreamsUser(testUser);
			if (user != null) {
				if (user.getStream() != null) {
					liveUsers.add(user.getStream());
				}
			} else {
				System.out.println("ERROR: User is null in getLiveStreams. User: " + testUser);
			}
		}

		return liveUsers;
	}

	public ArrayList<Stream> getLiveStreamsThreaded(String[] streams) {
		ArrayList<Stream> liveUsers = new ArrayList();
		ExecutorService es = Executors.newCachedThreadPool();

		for (String testUser : streams) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					StreamsUser user;
					user = puller.getStreamsUser(testUser);
					if (user != null) {
						if (user.getStream() != null) {
							liveUsers.add(user.getStream());
						}
					} else {
						System.out.println("ERROR: User is null in getLiveStreams. User: " + testUser);
					}
				}

			});
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		es.shutdown();
		try {
			es.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liveUsers;
	}
}
