package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.VendorDaoImpl;
import pojos.AcctType;
import pojos.BankAccount;
import pojos.Location;
import pojos.Vendor;

public class GetVendorDetails {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			VendorDaoImpl vendorDao = new VendorDaoImpl();
			System.out.println("Enter vendor email");
			System.out.println(vendorDao.fetchVendorDetails(sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
