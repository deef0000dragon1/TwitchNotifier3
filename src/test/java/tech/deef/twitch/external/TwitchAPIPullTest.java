package tech.deef.twitch.external;

import static org.junit.Assert.*;

import org.junit.Test;

import tech.deef.twitch.domain.ChannelsUser;
import tech.deef.twitch.domain.StreamsUser;
import tech.deef.twitch.domain.UserFollowsChannels;
import tech.deef.twitch.external.TwitchAPIPull;
import tech.deef.twitch.manipulation.GetFollowed;
import tech.deef.twitch.manipulation.GetStreams;

public class TwitchAPIPullTest {
	
	//api key location https://www.twitch.tv/settings/connections 
	
	private final int TEST_MODE = 0;
	//0: offline
	//1: online 
	
	
	@SuppressWarnings("unused")
	@Test
	public void testGetUserFollowsChannels() {
		DataPull puller;
		if(TEST_MODE == 0){
			puller = new LocalPuller();
		}else{
			puller = new DataPuller();
		}	
		TwitchAPI pull = new TwitchAPIPull(puller);
		
		UserFollowsChannels ufc = pull.getUserFollowsChannels("deef0000dragon1");
		
		assertNotNull(ufc);
		assertEquals("AlexSavageOMFG", ufc.getFollows().get(0).getChannel().getDisplayName());
		assertEquals("jadedcat", ufc.getFollows().get(47).getChannel().getDisplayName());

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetChannelsUser() {
		DataPull puller;
		if(TEST_MODE == 0){
			puller = new LocalPuller();
		}else{
			puller = new DataPuller();
		}
		TwitchAPI pull = new TwitchAPIPull(puller);
		
		
		ChannelsUser cu = pull.getChannelsUser("deef0000dragon1");
		
		assertNotNull(cu);
		assertEquals("Deef0000dragon1", cu.getDisplayName());

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetStreamsUserNull() {
		
		DataPull puller;
		if(TEST_MODE == 0){
			puller = new LocalPuller();
		}else{
			puller = new DataPuller();
		}
		TwitchAPI pull = new TwitchAPIPull(puller);
		
		StreamsUser su = pull.getStreamsUser("Deef0000dragon1");
		// tests I can pull user info
		assertNotNull(su);
		// makes sure a channel that is offline has no stream information
		assertNull(su.getStream());
	}

	@Test
	public void testGetStreamsUser() {
		String TestChannel = "BobRoss";

		DataPull puller;
		//this test should always be local as the TestChannel may not always be live. 
		puller = new LocalPuller();
		
		TwitchAPI pull = new TwitchAPIPull(puller);
		
		StreamsUser su = pull.getStreamsUser(TestChannel);
		
		assertNotNull(su);
		assertNotNull(su.getStream());
		assertEquals(TestChannel, su.getStream().getChannel().getDisplayName());

	}
	
	@Test
	public void testGetKracken() {

		//this test must be done online to confirm the key validity
		DataPull local = new DataPuller();
		TwitchAPI pull = new TwitchAPIPull(local);
		String str = pull.getKracken("https://api.twitch.tv/kraken");
		assertNotNull(str);
		assertTrue(str.contains("{\"identified\":true,"));
	}
	
	@Test
	public void testHTMLOutput(){
		
		
		String username = "deef0000dragon1";
		DataPull pull = new DataPuller();
		TwitchAPI puller = new TwitchAPIPull(pull);
		GetStreams pulling = new GetStreams(puller);
		String[] liveNames = null;
		liveNames = pulling.getLiveStreams(GetFollowed.getFollowed(puller.getUserFollowsChannels(username)));

		for (String name : liveNames) {
			System.out.println(name + " is live");
		}
		assertNotNull(liveNames);

		//System.out.println("<h1>" + "input user: " + "</h1>");
		
	}
	
	
	
	
}
