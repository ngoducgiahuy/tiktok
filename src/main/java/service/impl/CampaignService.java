package service.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import model.Campaign;
import service.EntityService;
import utils.HibernateUtils;

public class CampaignService implements EntityService {

	public JSONArray getDataCampaign(String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		String path = "/open_api/v1.2/campaign/get/";
		return this.getListWithAllData(path, accessToken, advertiserId);
	}

	public void importData(String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		JSONArray resultList = this.getDataCampaign(accessToken, advertiserId);
		Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
		for (Object camp : resultList) {
			Campaign campaignEntity = convertToEntity(camp);
			System.out.println(convertToEntity(camp));
			session.saveOrUpdate(campaignEntity);
		}
		session.getTransaction().commit();
        HibernateUtils.shutdown();

	}

	public Campaign convertToEntity(Object obj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		Campaign campaignModel = mapper.readValue(obj.toString(), Campaign.class);
		return campaignModel;
	}
	
	

}
