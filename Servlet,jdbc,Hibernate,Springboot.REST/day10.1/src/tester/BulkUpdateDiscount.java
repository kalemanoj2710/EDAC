package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class BulkUpdateDiscount {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("Enter discount n date(yr-mon-day)");
			System.out.println(dao.applyDiscount(sc.nextDouble(), LocalDate.parse(sc.next())));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
