package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;
import static java.time.LocalDate.parse;
import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;

public class GetSelectedUserDetailsConstrExpression {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter begin date  end date n role");

			dao.fetchSelectedUserDetailsConstrExpr(parse(sc.next()), parse(sc.next()), 
					Role.valueOf(sc.next().toUpperCase()))
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
