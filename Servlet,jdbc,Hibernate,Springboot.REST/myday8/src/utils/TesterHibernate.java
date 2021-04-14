package utils;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;

public class TesterHibernate {
	public static void main(String[] args) {
		try (SessionFactory factory = getSf()) {

			System.out.println("Hibernaate up n running " + factory);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
