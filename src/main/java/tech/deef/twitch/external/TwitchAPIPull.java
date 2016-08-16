package tech.deef.twitch.external;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.deef.twitch.domain.ChannelsUser;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.domain.UserFollowsChannels;

public class TwitchAPIPull implements TwitchAPI {

	private DataPull puller = null;
	
	public TwitchAPIPull(DataPull puller){
		this.puller = puller;
	}

	public UserFollowsChannels getUserFollowsChannels(String user) {
		String link = "https://api.twitch.tv/kraken/users/" + user
				+ "/follows/channels?direction=DESC&limit=5&offset=0&sortby=created_a";
		UserFollowsChannels ufc = this.<UserFollowsChannels>getPOJO(link, UserFollowsChannels.class);
		int channels = ufc.getTotal();
		link = "https://api.twitch.tv/kraken/users/" + user
				+ "/follows/channels?direction=DESC&limit=" + channels +"&offset=0&sortby=created_a";
		return this.<UserFollowsChannels>getPOJO(link, UserFollowsChannels.class);
		
	}

	public StreamsUser getStreamsUser(String user) {
		String link = "https://api.twitch.tv/kraken/streams/" + user;
		return this.<StreamsUser>getPOJO(link, StreamsUser.class);
	}

	public ChannelsUser getChannelsUser(String user) {
		String link = "https://api.twitch.tv/kraken/channels/" + user;
		return this.<ChannelsUser>getPOJO(link, ChannelsUser.class);
	}
	
	public String getKracken(String link){
		return puller.PullData(link);
	}

	private <T> T getPOJO(String link, Class c) {

		String data = puller.PullData(link);

		ObjectMapper mapper = new ObjectMapper();
		T obj = null;

		try {
			obj = (T) mapper.readValue(data, c);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;

	}

}
