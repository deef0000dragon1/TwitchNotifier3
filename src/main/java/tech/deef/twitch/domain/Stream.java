package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {

	@JsonProperty("_id")
	private long id;
	@JsonProperty("game")
	private String game;
	@JsonProperty("viewers")
	private int viewers;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("video_height")
	private int videoHeight;
	@JsonProperty("average_fps")
	private double averageFPS;
	@JsonProperty("delay")
	private double delay;
	@JsonProperty("is_playlist")
	private boolean isPlaylist;
	@JsonProperty("_links")
	private Links links;
	@JsonProperty("preview")
	private Preview preview;
	@JsonProperty("channel")
	private Channel channel;

	public long getId() {
		return id;
	}

	public String getGame() {
		return game;
	}

	public int getViewers() {
		return viewers;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public int getVideoHeight() {
		return videoHeight;
	}

	public double getAverageFPS() {
		return averageFPS;
	}

	public double getDelay() {
		return delay;
	}

	public boolean isPlaylist() {
		return isPlaylist;
	}

	public Links getLinks() {
		return links;
	}

	public Preview getPreview() {
		return preview;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setVideoHeight(int videoHeight) {
		this.videoHeight = videoHeight;
	}

	public void setAverageFPS(double averageFPS) {
		this.averageFPS = averageFPS;
	}

	public void setDelay(double delay) {
		this.delay = delay;
	}

	public void setPlaylist(boolean isPlaylist) {
		this.isPlaylist = isPlaylist;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public void setPreview(Preview preview) {
		this.preview = preview;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
