package utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Campaign;

public class DBUtils {
	
	public List<Object> selectData(Object obj) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();
		List<Object> resultList = null;

		try {
			session.getTransaction().begin();


			String sql = "Select c from " + obj.getClass().getName() + " c ";

			Query<Object> query = session.createQuery(sql);

			resultList = query.getResultList();

			
//			for (Campaign camp : campaigns) {
//				System.out.println("ID: " + camp.getCampaignId());
//			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return resultList;
	}

}
