package utils;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.service.*;

public class HibernateUtils {
	private static SessionFactory sf;
	private static Session session;
	static {
		try {
			System.out.println("in static init block...");
			// reg
			ServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
			// sf
			sf = new MetadataSources(reg).buildMetadata().buildSessionFactory();
			System.out.println("sf created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSf() {
		return sf;
	}
	public static Session getSession() {
		return sf.getCurrentSession();
	}
	

}
