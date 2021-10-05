package service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import utils.HttpHelper;

public interface EntityService {
	public default JSONObject getData(String path, String accessToken, Long advertiserId, int countTotalRecord)
			throws JSONException, IOException, URISyntaxException {
		HttpHelper helper = new HttpHelper(accessToken, path);
		String myArgs = String.format("{\"advertiser_id\": \"%s\", \"page_size\": \"%s\"}", advertiserId, countTotalRecord);
		JSONObject objResult = new JSONObject(helper.get(myArgs));
		return objResult;
	}

	public default JSONArray getListWithAllData(String path, String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		JSONObject rawData = this.getData(path, accessToken, advertiserId, 1);
		int countTotalRecord = rawData.getJSONObject("data").getJSONObject("page_info")
				.getInt("total_number");
		rawData = this.getData(path, accessToken, advertiserId, countTotalRecord);
		JSONArray listRecord = rawData.getJSONObject("data").getJSONArray("list");
		System.out.println(listRecord);
		return listRecord;
	}
	
	public Object convertToEntity(Object obj) throws JsonMappingException, JsonProcessingException;

}
