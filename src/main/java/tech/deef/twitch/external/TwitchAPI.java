package tech.deef.twitch.external;

import tech.deef.twitch.domain.ChannelsUser;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.domain.UserFollowsChannels;

public interface TwitchAPI {

	public UserFollowsChannels getUserFollowsChannels(String user); 
	public StreamsUser getStreamsUser(String user);
	public ChannelsUser getChannelsUser(String user);
	public String getKracken(String link);
}
