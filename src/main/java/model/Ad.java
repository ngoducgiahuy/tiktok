package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tk_ad")
public class Ad {
	@Id
	@Column(name = "ad_id")
	@JsonProperty(value = "ad_id")
	private Long adId;

	@Column(name = "ad_name")
	@JsonProperty(value = "ad_name")
	private String adName;

	@Column(name = "advertiser_id")
	@JsonProperty(value = "advertiser_id")
	private Long advertiserId;

	@Column(name = "campaign_id")
	@JsonProperty(value = "campaign_id")
	private Long campaignId;
	
	@Column(name = "campaign_name")
	@JsonProperty(value = "campaign_name")
	private String campaignName;
	
	@Column(name = "adgroup_id")
	@JsonProperty(value = "adgroup_id")
	private Long adgroupId;
	
	@Column(name = "adgroup_name")
	@JsonProperty(value = "adgroup_name")
	private String adgroupName;
	
	@Column(name = "ad_text")
	@JsonProperty(value = "ad_text")
	private String adText;
	
	@Column(name = "ad_format")
	@JsonProperty(value = "ad_format")
	private String adFormat;
	
	@Column(name = "status")
	@JsonProperty(value = "status")
	private String status;
	
	@Column(name = "opt_status")
	@JsonProperty(value = "opt_status")
	private String optStatus;
	
	@Column(name = "app_name")
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

	public Ad(Long adId, String adName, Long advertiserId, Long campaignId, String campaignName, Long adgroupId,
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

	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}
}
