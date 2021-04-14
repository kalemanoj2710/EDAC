package tester;

import java.util.Scanner;

import dao.AccountDaoImpl;

public class TestStoreProcedure {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			AccountDaoImpl dao = new AccountDaoImpl();
			System.out.println("enter src acc,dest accno,amount to transfer");
			System.out.println(dao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
