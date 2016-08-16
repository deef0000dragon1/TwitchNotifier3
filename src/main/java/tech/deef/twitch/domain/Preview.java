package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preview {
	@JsonProperty("small")
	private String small;
	@JsonProperty("medium")
	private String medium;
	@JsonProperty("large")
	private String large;
	@JsonProperty("template")
	private String template;

	public String getSmall() {
		return small;
	}

	public String getMedium() {
		return medium;
	}

	public String getLarge() {
		return large;
	}

	public String getTemplate() {
		return template;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
