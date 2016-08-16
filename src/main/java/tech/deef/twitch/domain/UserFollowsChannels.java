package tech.deef.twitch.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFollowsChannels {

	@JsonProperty("_total")
	private int total;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("follows")
	private List<Followed> follows;

	public int getTotal() {
		return total;
	}

	public Links getLinks() {
		return links;
	}

	public List<Followed> getFollows() {
		return follows;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public void setFollows(List<Followed> follows) {
		this.follows = follows;
	}

}
