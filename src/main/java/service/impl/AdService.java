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

import dto.AdDto;
import model.Ad;
import service.EntityService;

public class AdService implements EntityService{
	public JSONArray getDataAd(String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		String path = "/open_api/v1.2/ad/get/";
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("advertiser_id");
		fieldList.add("campaign_id");
		fieldList.add("campaign_name");
		fieldList.add("adgroup_id");
		fieldList.add("adgroup_name");
		fieldList.add("ad_id");
		fieldList.add("ad_name");
		fieldList.add("ad_text");
		fieldList.add("ad_format");
		fieldList.add("status");
		fieldList.add("opt_status");	
		fieldList.add("app_name");
		return this.getListWithAllData(path, accessToken, advertiserId, fieldList);
	}
	
	public void importData(String accessToken, Long advertiserId, Session session)
			throws JSONException, IOException, URISyntaxException {
		JSONArray resultList = this.getDataAd(accessToken, advertiserId);
		for (Object ad : resultList) {
			AdDto adDto = convertToDto(ad);
			Ad adEntity = convertToEntity(adDto);
			session.saveOrUpdate(adEntity);
		}
	}
	
	public AdDto convertToDto(Object obj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		AdDto adgroupDto = mapper.readValue(obj.toString(), AdDto.class);
		return adgroupDto;
	}
	
	public Ad convertToEntity (AdDto adDto) {
		ModelMapper mapper = new ModelMapper();
		Ad adModel = mapper.map(adDto, Ad.class);
		return adModel;
	}
}
