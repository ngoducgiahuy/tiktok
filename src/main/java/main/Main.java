package main;

import java.io.IOException;
import java.net.URISyntaxException;

import org.hibernate.Session;
import org.json.JSONException;

import service.impl.AdGroupService;
import service.impl.AdService;
import service.impl.CampaignService;
import utils.HibernateUtils;

public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException {
		String accessToken = "8fc7854be9412a39df88a761e22461ab875696fe";
		Long advertiserID = 6791983391823626245L;
		
		importData(accessToken, advertiserID);
	}
	
	public static void importData(String accessToken, Long advertiserId) throws JSONException, IOException, URISyntaxException {
		Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        
        CampaignService campainService = new CampaignService();
		campainService.importData(accessToken, advertiserId, session);
		

		AdGroupService adgroupService = new AdGroupService();
		adgroupService.importData(accessToken, advertiserId, session);
		
		AdService adService = new AdService();
		adService.importData(accessToken, advertiserId, session);
        
        session.getTransaction().commit();
        HibernateUtils.shutdown();
	}
}
