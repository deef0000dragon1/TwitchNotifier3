package tech.deef.twitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelsUser{

	@JsonProperty("_links")
	private Links links;
	
	@JsonProperty("background")
	private String background;
	
	@JsonProperty("banner")
	private String banner;
	
	@JsonProperty("broadcaster_language")
	private String broadcasterLanguage;
	
	@JsonProperty("display_name")
	private String displayName;
	
	@JsonProperty("game")
	private String game;
	
	@JsonProperty("logo")
	private String logo;
	
	@JsonProperty("mature")
	private boolean mature;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("partner")
	private boolean partner;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("video_banner")
	private String videoBanner;
	
	@JsonProperty("_id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("delay")
	private String delay;
	
	@JsonProperty("followers")
	private int followers;
	
	@JsonProperty("profile_banner")
	private String profileBanner;
	
	@JsonProperty("profile_banner_background_color")
	private String profileBannerBackgroundColor;
	
	@JsonProperty("views")
	private int views;
	
	@JsonProperty("language")
	private String language;

	public Links getLinks() {
		return links;
	}

	public String getBackground() {
		return background;
	}

	public String getBanner() {
		return banner;
	}

	public String getBroadcasterLanguage() {
		return broadcasterLanguage;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getGame() {
		return game;
	}

	public String getLogo() {
		return logo;
	}

	public boolean isMature() {
		return mature;
	}

	public String getStatus() {
		return status;
	}

	public boolean isPartner() {
		return partner;
	}

	public String getUrl() {
		return url;
	}

	public String getVideoBanner() {
		return videoBanner;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getDelay() {
		return delay;
	}

	public int getFollowers() {
		return followers;
	}

	public String getProfileBanner() {
		return profileBanner;
	}

	public String getProfileBannerBackgroundColor() {
		return profileBannerBackgroundColor;
	}

	public int getViews() {
		return views;
	}

	public String getLanguage() {
		return language;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public void setBroadcasterLanguage(String broadcasterLanguage) {
		this.broadcasterLanguage = broadcasterLanguage;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setMature(boolean mature) {
		this.mature = mature;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPartner(boolean partner) {
		this.partner = partner;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVideoBanner(String videoBanner) {
		this.videoBanner = videoBanner;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public void setProfileBanner(String profileBanner) {
		this.profileBanner = profileBanner;
	}

	public void setProfileBannerBackgroundColor(String profileBannerBackgroundColor) {
		this.profileBannerBackgroundColor = profileBannerBackgroundColor;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
