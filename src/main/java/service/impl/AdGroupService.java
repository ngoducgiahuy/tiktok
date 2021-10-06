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

import dto.AdgroupDto;
import model.Adgroup;
import service.EntityService;
import utils.FunctionHelper;

public class AdGroupService implements EntityService {
	
	public JSONArray getDataAdgroup(String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		String path = "/open_api/v1.2/adgroup/get/";
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("advertiser_id");
		fieldList.add("campaign_id");
		fieldList.add("campaign_name");
		fieldList.add("adgroup_id");
		fieldList.add("adgroup_name");
		fieldList.add("status");
		fieldList.add("opt_status");
		fieldList.add("create_time");
		fieldList.add("modify_time");
		fieldList.add("schedule_start_time");
		fieldList.add("schedule_end_time");
		fieldList.add("age");
		fieldList.add("gender");
		fieldList.add("languages");
		fieldList.add("location");
		return this.getListWithAllData(path, accessToken, advertiserId, fieldList);
	}
	
	public void importData(String accessToken, Long advertiserId, Session session)
			throws JSONException, IOException, URISyntaxException {
		JSONArray resultList = this.getDataAdgroup(accessToken, advertiserId);
		for (Object adgroup : resultList) {
			AdgroupDto adgroupDto = convertToDto(adgroup);
			Adgroup adgroupEntity = convertToEntity(adgroupDto);
			System.out.println(adgroupEntity);
			session.saveOrUpdate(adgroupEntity);
		}

	}
	
	public AdgroupDto convertToDto(Object obj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		AdgroupDto adgroupDto = mapper.readValue(obj.toString(), AdgroupDto.class);
		return adgroupDto;
	}
	
	public Adgroup convertToEntity (AdgroupDto adgroupDto) {
		ModelMapper mapper = new ModelMapper();
		Adgroup adgroupModel = mapper.map(adgroupDto, Adgroup.class);
		adgroupModel.setAge(FunctionHelper.convertArrayToString(adgroupDto.getAge()));
		adgroupModel.setLocation(FunctionHelper.convertArrayToString(adgroupDto.getLocation()));
		adgroupModel.setLanguages(FunctionHelper.convertArrayToString(adgroupDto.getLanguages()));
		return adgroupModel;
	}

}
