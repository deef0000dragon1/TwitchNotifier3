package tech.deef.twitch.manipulation;

import tech.deef.twitch.domain.Channel;
import tech.deef.twitch.domain.Followed;
import tech.deef.twitch.domain.UserFollowsChannels;

public class GetFollowed {

	public static String[] getFollowed(UserFollowsChannels ufc){
		int followed = ufc.getTotal(); 
		String[] names = new String[followed];
		for(int i = 0; i<followed; i++){
			//gets the display name from the ith channel and adds it to the array. 
			names[i] = ufc.getFollows().get(i).getChannel().getDisplayName();
		}
		return names;
	}
}
