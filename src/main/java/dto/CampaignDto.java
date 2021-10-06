package dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignDto {
	@JsonProperty(value = "campaign_id")
	private Long campaignId;

	@JsonProperty(value = "advertiser_id")
	private Long advertiserId;

	@JsonProperty(value = "campaign_name")
	private String campaignName;

	@JsonProperty(value = "budget")
	private Double budget;

	@JsonProperty(value = "budget_mode")
	private String budgetMode;

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "opt_status")
	private String optStatus;

	@JsonProperty(value = "objective")
	private String objective;

	@JsonProperty(value = "objective_type")
	private String objectiveType;

	@JsonProperty(value = "create_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	@JsonProperty(value = "modify_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyTime;

	@JsonProperty(value = "budget_optimize")
	private String budgetOptimize;

	@JsonProperty(value = "bid_type")
	private String bidType;

	@JsonProperty(value = "optimize_goal")
	private String optimizeGoal;

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public Long getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Long advertiserId) {
		this.advertiserId = advertiserId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getBudgetMode() {
		return budgetMode;
	}

	public void setBudgetMode(String budgetMode) {
		this.budgetMode = budgetMode;
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

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getObjectiveType() {
		return objectiveType;
	}

	public void setObjectiveType(String objectiveType) {
		this.objectiveType = objectiveType;
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

	public String getBudgetOptimize() {
		return budgetOptimize;
	}

	public void setBudgetOptimize(String budgetOptimize) {
		this.budgetOptimize = budgetOptimize;
	}

	public String getBidType() {
		return bidType;
	}

	public void setBidType(String bidType) {
		this.bidType = bidType;
	}

	public String getOptimizeGoal() {
		return optimizeGoal;
	}

	public void setOptimizeGoal(String optimizeGoal) {
		this.optimizeGoal = optimizeGoal;
	}

	public CampaignDto(Long campaignId, Long advertiserId, String campaignName, Double budget, String budgetMode,
			String status, String optStatus, String objective, String objectiveType, LocalDateTime createTime,
			LocalDateTime modifyTime, String budgetOptimize, String bidType, String optimizeGoal) {
		super();
		this.campaignId = campaignId;
		this.advertiserId = advertiserId;
		this.campaignName = campaignName;
		this.budget = budget;
		this.budgetMode = budgetMode;
		this.status = status;
		this.optStatus = optStatus;
		this.objective = objective;
		this.objectiveType = objectiveType;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.budgetOptimize = budgetOptimize;
		this.bidType = bidType;
		this.optimizeGoal = optimizeGoal;
	}

	public CampaignDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "campaignId: " + campaignId + ", advertiserId: " + advertiserId + ", campaignName: " + campaignName
				+ ", budget: " + budget + ", budgetMode: " + budgetMode + ", status: " + status + ", optStatus: "
				+ optStatus + ", objective: " + objective + ", objectiveType: " + objectiveType + ", createTime: "
				+ createTime + ", modifyTime: " + modifyTime + ", budgetOptimize: " + budgetOptimize + ", bidType: "
				+ bidType + ", optimizeGoal: " + optimizeGoal;
	}
}
