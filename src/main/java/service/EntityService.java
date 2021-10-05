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
	public default JSONObject getData(String path, String accessToken, Long advertiserId, int page, int pageSize)
			throws JSONException, IOException, URISyntaxException {
		HttpHelper helper = new HttpHelper(accessToken, path);
		String myArgs = String.format("{\"advertiser_id\": \"%s\", \"page\": \"%s\", \"page_size\": \"%s\"}",
				advertiserId, page, pageSize);
		JSONObject objResult = new JSONObject(helper.get(myArgs));
		return objResult;
	}

	public default JSONArray getListWithAllData(String path, String accessToken, Long advertiserId)
			throws JSONException, IOException, URISyntaxException {
		int page = 1;
		int pageSize = 20;

		JSONObject rawData = this.getData(path, accessToken, advertiserId, page, pageSize);
		int totalRecord = rawData.getJSONObject("data").getJSONObject("page_info").getInt("total_number");

		JSONArray listRecord = rawData.getJSONObject("data").getJSONArray("list");

		while (totalRecord > page * pageSize) {
			page += 1;
			rawData = this.getData(path, accessToken, advertiserId, page, pageSize);
			listRecord = listRecord.putAll(rawData.getJSONObject("data").getJSONArray("list"));
		}
		return listRecord;
	}

}
