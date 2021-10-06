package service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.CampaignDto;
import model.Campaign;
import service.EntityService;

public class CampaignService implements EntityService {

	public JSONArray getDataCampaign(String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		String path = "/open_api/v1.2/campaign/get/";
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("advertiser_id");
		fieldList.add("campaign_id");
		fieldList.add("campaign_name");
		fieldList.add("budget");
		fieldList.add("budget_mode");
		fieldList.add("status");
		fieldList.add("opt_status");
		fieldList.add("objective");
		fieldList.add("objective_type");
		fieldList.add("create_time");
		fieldList.add("modify_time");	
		fieldList.add("budget_optimize_switch");
		fieldList.add("bid_type");
		fieldList.add("optimize_goal");
		return this.getListWithAllData(path, accessToken, advertiserId, fieldList);
	}

	public void importData(String accessToken, Long advertiserId, Session session)
			throws JSONException, IOException, URISyntaxException {
		JSONArray resultList = this.getDataCampaign(accessToken, advertiserId);
		for (Object camp : resultList) {
			CampaignDto campaignDto = convertToDto(camp);
			Campaign campaignEntity = convertToEntity(campaignDto);
			session.saveOrUpdate(campaignEntity);
		}
	}
	
	public CampaignDto convertToDto(Object obj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		CampaignDto campaignDto = mapper.readValue(obj.toString(), CampaignDto.class);
		return campaignDto;
	}
	
	public Campaign convertToEntity (CampaignDto campaignDto) {
		ModelMapper mapper = new ModelMapper();
		Campaign campaignModel = mapper.map(campaignDto, Campaign.class);
		return campaignModel;
	}
	
	

}
