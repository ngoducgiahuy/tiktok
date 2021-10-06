package dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AdDto {
	@JsonProperty(value = "ad_id")
	private Long adId;

	@JsonProperty(value = "ad_name")
	private String adName;

	@JsonProperty(value = "advertiser_id")
	private Long advertiserId;

	@JsonProperty(value = "campaign_id")
	private Long campaignId;
	
	@JsonProperty(value = "campaign_name")
	private String campaignName;
	
	@JsonProperty(value = "adgroup_id")
	private Long adgroupId;
	
	@JsonProperty(value = "adgroup_name")
	private String adgroupName;
	
	@JsonProperty(value = "ad_text")
	private String adText;
	
	@JsonProperty(value = "ad_format")
	private String adFormat;
	
	@JsonProperty(value = "status")
	private String status;
	
	@JsonProperty(value = "opt_status")
	private String optStatus;
	
	@JsonProperty(value = "app_name")
	private String appName;

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Long getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Long advertiserId) {
		this.advertiserId = advertiserId;
	}

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Long getAdgroupId() {
		return adgroupId;
	}

	public void setAdgroupId(Long adgroupId) {
		this.adgroupId = adgroupId;
	}

	public String getAdgroupName() {
		return adgroupName;
	}

	public void setAdgroupName(String adgroupName) {
		this.adgroupName = adgroupName;
	}

	public String getAdText() {
		return adText;
	}

	public void setAdText(String adText) {
		this.adText = adText;
	}

	public String getAdFormat() {
		return adFormat;
	}

	public void setAdFormat(String adFormat) {
		this.adFormat = adFormat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOptStatus() {
		return optStatus;
	}

	public void setOptStatus(String optStatus) {
		this.optStatus = optStatus;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public AdDto(Long adId, String adName, Long advertiserId, Long campaignId, String campaignName, Long adgroupId,
			String adgroupName, String adText, String adFormat, String status, String optStatus, String appName) {
		super();
		this.adId = adId;
		this.adName = adName;
		this.advertiserId = advertiserId;
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.adgroupId = adgroupId;
		this.adgroupName = adgroupName;
		this.adText = adText;
		this.adFormat = adFormat;
		this.status = status;
		this.optStatus = optStatus;
		this.appName = appName;
	}

	public AdDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
