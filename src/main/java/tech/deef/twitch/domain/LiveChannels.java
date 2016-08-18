package tech.deef.twitch.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveChannels {

	@JsonProperty("live")
	private List<String> live;

	
	public List<String> getLive() {
		return live;
	}

	public void setLive(List<String> live) {
		this.live = live;
	}
}
