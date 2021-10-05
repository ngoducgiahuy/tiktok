package utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHelper {

	private String accessToken;
	private String path;
	private static final ObjectMapper mapper = new ObjectMapper();


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpHelper(String accessToken, String path) {
		super();
		this.accessToken = accessToken;
		this.path = path;
	}

	public String get(String jsonStr) throws IOException, URISyntaxException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		URIBuilder ub = new URIBuilder(buildUrl(path));
		Map<String, Object> map = mapper.readValue(jsonStr, Map.class);
		map.forEach((k, v) -> {
			try {
				ub.addParameter(k, v instanceof String ? (String) v : mapper.writeValueAsString(v));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});
		URL url = ub.build().toURL();

		Request request = new Request.Builder().url(url).method("GET", null).addHeader("Access-Token", accessToken)
				.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	private static String buildUrl(String path) throws URISyntaxException {
		URI uri = new URI("https", "business-api.tiktok.com", path, "", "");
		return uri.toString();
	}
}
