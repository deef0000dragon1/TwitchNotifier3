package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsUser {

	@JsonProperty("stream")
	private Stream stream;
	@JsonProperty("_links")
	private Links links;

	public Stream getStream() {
		return stream;
	}

	public Links getLinks() {
		return links;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
}
