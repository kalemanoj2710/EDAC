package tester;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.VendorDaoImpl;
import pojos.AcctType;
import pojos.BankAccount;
import pojos.Vendor;
public class VendorRegsitration {

	public static void main(String[] args) {
		try(SessionFactory factory=getSf();Scanner sc=new Scanner(System.in))
		{
			VendorDaoImpl vendorDao=new VendorDaoImpl();
			System.out.println("Enter vendor details : name,  email,  password,  regAmount,  regDate");
			Vendor v=new Vendor(sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println("Enter 1st Acct details : acct type n balance");
			BankAccount a1=new BankAccount(AcctType.valueOf(sc.next()),sc.nextDouble());
			v.addAccount(a1);
			System.out.println("Enter 2nd acct details : acct type n balance");
			BankAccount a2=new BankAccount(AcctType.valueOf(sc.next()),sc.nextDouble());
			v.addAccount(a2);
			System.out.println(vendorDao.registerVendor(v));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
