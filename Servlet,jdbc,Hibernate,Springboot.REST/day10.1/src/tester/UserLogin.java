package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.*;

import dao.UserDaoImpl;

public class UserLogin {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user email n pwd");
			System.out.println("Successful Login , Details " + dao.authenticateUser(sc.next(), sc.next()));
		} 
		catch (NoResultException e) {
			System.out.println(e);
			System.out.println("Invalid login , pls retry!!!!!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
