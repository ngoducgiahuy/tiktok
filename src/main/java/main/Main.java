package main;

import java.io.IOException;
import java.net.URISyntaxException;

import service.impl.AdGroupService;
import service.impl.AdService;

public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException {
		String accessToken = "8fc7854be9412a39df88a761e22461ab875696fe";
		Long advertiserID = 6791983391823626245L;
//		CampaignService campainService = new CampaignService();
//		campainService.getDataCampaign(accessToken, advertiserID);
		
//		AdGroupService adgroupService = new AdGroupService();
//		adgroupService.importData(accessToken, advertiserID);
		
		AdService adService = new AdService();
		adService.importData(accessToken, advertiserID);
		
	}
}
