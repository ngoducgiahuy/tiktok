package service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.HttpHelper;

public interface EntityService {
	public default JSONObject getData(String path, String accessToken, Long advertiserId, int page, int pageSize, String fields)
			throws JSONException, IOException, URISyntaxException {
		HttpHelper helper = new HttpHelper(accessToken, path);
		String myArgs = String.format("{\"advertiser_id\": \"%s\", \"fields\": [%s], \"page\": \"%s\", \"page_size\": \"%s\"}",
				advertiserId, fields, page, pageSize);
		JSONObject objResult = new JSONObject(helper.get(myArgs));
		return objResult;
	}

	public default JSONArray getListWithAllData(String path, String accessToken, Long advertiserId, List<String> fieldList)
			throws JSONException, IOException, URISyntaxException {
		int page = 1;
		int pageSize = 20;
        String fields = fieldList.stream().map(s -> String.format("\"%s\"", s)).collect(Collectors.joining(", "));
		
		JSONObject rawData = this.getData(path, accessToken, advertiserId, page, pageSize, fields);
		int totalRecord = rawData.getJSONObject("data").getJSONObject("page_info").getInt("total_number");

		JSONArray listRecord = rawData.getJSONObject("data").getJSONArray("list");

		while (totalRecord > page * pageSize) {
			page += 1;
			rawData = this.getData(path, accessToken, advertiserId, page, pageSize, fields);
			listRecord = listRecord.putAll(rawData.getJSONObject("data").getJSONArray("list"));
		}
		return listRecord;
	}

}
