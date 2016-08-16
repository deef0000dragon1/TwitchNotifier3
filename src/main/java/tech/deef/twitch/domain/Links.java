package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

	@JsonProperty("self")
	private String self;

	@JsonProperty("follows")
	private String follows;
	
	@JsonProperty("commercial")
	private String commercial;
	
	@JsonProperty("stream_key")
	private String streamKey;
	
	@JsonProperty("chat")
	private String chat;
	
	@JsonProperty("features")
	private String features;
	
	@JsonProperty("subscriptions")
	private String subscriptions;
	
	@JsonProperty("editors")
	private String editors;
	
	@JsonProperty("videos")
	private String videos;
	
	@JsonProperty("teams")
	private String teams;

	public String getSelf() {
		return self;
	}

	public String getFollows() {
		return follows;
	}

	public String getCommercial() {
		return commercial;
	}

	public String getStreamKey() {
		return streamKey;
	}

	public String getChat() {
		return chat;
	}

	public String getFeatures() {
		return features;
	}

	public String getSubscriptions() {
		return subscriptions;
	}

	public String getEditors() {
		return editors;
	}

	public String getVideos() {
		return videos;
	}

	public String getTeams() {
		return teams;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public void setFollows(String follows) {
		this.follows = follows;
	}

	public void setCommercial(String commercial) {
		this.commercial = commercial;
	}

	public void setStreamKey(String streamKey) {
		this.streamKey = streamKey;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void setEditors(String editors) {
		this.editors = editors;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

}
