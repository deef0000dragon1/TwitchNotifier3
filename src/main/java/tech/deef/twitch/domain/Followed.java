package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Followed {

	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("_links")
	private Links links;
	
	@JsonProperty("notifications")
	private boolean notifications;
	
	@JsonProperty("channel")
	private Channel channel;

	public String getCreatedAt() {
		return createdAt;
	}

	public Links getLinks() {
		return links;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
