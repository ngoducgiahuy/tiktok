package dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AdgroupDto {
	@JsonProperty(value = "adgroup_id")
	private Long adgroupId;
	
	@JsonProperty(value = "advertiser_id")
	private Long advertiserId;

	@JsonProperty(value = "campaign_id")
	private Long campaignId;

	@JsonProperty(value = "campaign_name")
	private String campaignName;

	@JsonProperty(value = "adgroup_name")
	private String adgroupName;

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "opt_status")
	private String optStatus;

	@JsonProperty(value = "create_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	@JsonProperty(value = "modify_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyTime;

	@JsonProperty(value = "schedule_start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime scheduleStartTime;

	@JsonProperty(value = "schedule_end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime scheduleEndTime;

	@JsonProperty(value = "age")
	private String[] age;

	@JsonProperty(value = "gender")
	private String gender;

	@JsonProperty(value = "languages")
	private String[] languages;

	@JsonProperty(value = "location")
	private String[] location;

	public Long getAdgroupId() {
		return adgroupId;
	}

	public void setAdgroupId(Long adgroupId) {
		this.adgroupId = adgroupId;
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

	public String getAdgroupName() {
		return adgroupName;
	}

	public void setAdgroupName(String adgroupName) {
		this.adgroupName = adgroupName;
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

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(LocalDateTime modifyTime) {
		this.modifyTime = modifyTime;
	}

	public LocalDateTime getScheduleStartTime() {
		return scheduleStartTime;
	}

	public void setScheduleStartTime(LocalDateTime scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}

	public LocalDateTime getScheduleEndTime() {
		return scheduleEndTime;
	}

	public void setScheduleEndTime(LocalDateTime scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	public String[] getAge() {
		return age;
	}

	public void setAge(String[] age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}

	public AdgroupDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdgroupDto(Long adgroupId, Long advertiserId, Long campaignId, String campaignName, String adgroupName,
			String status, String optStatus, LocalDateTime createTime, LocalDateTime modifyTime,
			LocalDateTime scheduleStartTime, LocalDateTime scheduleEndTime, String[] age, String gender,
			String[] languages, String[] location) {
		super();
		this.adgroupId = adgroupId;
		this.advertiserId = advertiserId;
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.adgroupName = adgroupName;
		this.status = status;
		this.optStatus = optStatus;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.scheduleStartTime = scheduleStartTime;
		this.scheduleEndTime = scheduleEndTime;
		this.age = age;
		this.gender = gender;
		this.languages = languages;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "adgroupId: " + adgroupId + ", advertiserId: " + advertiserId + ", campaignId: " + campaignId
				+ ", campaignName: " + campaignName + ", adgroupName: " + adgroupName + ", status: " + status + ", optStatus: "
				+ optStatus + ", scheduleStartTime: " + scheduleStartTime + ", scheduleEndTime: " + scheduleEndTime + ", createTime: "
				+ createTime + ", modifyTime: " + modifyTime + ", age: " + age + ", gender: "
				+ gender + ", languages: " + languages + ", location: " + location;
	}
}
