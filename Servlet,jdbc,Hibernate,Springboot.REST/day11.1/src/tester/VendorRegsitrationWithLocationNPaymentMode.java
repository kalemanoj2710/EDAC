package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.VendorDaoImpl;
import pojos.AcctType;
import pojos.BankAccount;
import pojos.Location;
import pojos.PaymentDetails;
import pojos.PaymentMode;
import pojos.Vendor;

public class VendorRegsitrationWithLocationNPaymentMode {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			VendorDaoImpl vendorDao = new VendorDaoImpl();
			System.out.println("Enter vendor details : name,  email,  password,  regAmount,  regDate");
			Vendor v = new Vendor(sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println("Enter 1st Acct details : acct type n balance");
			BankAccount a1 = new BankAccount(AcctType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			v.addAccount(a1);
			System.out.println("Enter 2nd acct details : acct type n balance");
			BankAccount a2 = new BankAccount(AcctType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			v.addAccount(a2);
			// accept location details n set it for the curnt vendor
			System.out.println("Enter vendor location details : city state country");
			Location location = new Location(sc.next(), sc.next(), sc.next());
			location.setCurrentVendor(v);
			// accept payment details
			System.out.println("Enter payment details : mode,  paymentDate, min amount");
			v.setDetails(new PaymentDetails(PaymentMode.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()),
					sc.nextDouble()));
			System.out.println(vendorDao.registerVendorWithLocation(location));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
