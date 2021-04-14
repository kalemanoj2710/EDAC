package maps;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.AcType;
import com.app.core.BankAccount;
import static java.time.LocalDate.parse;
import static com.app.core.AcType.*;
import static utils.BankValidationRules.validateBalance;

import custom_exception.AccountHandlingException;

public class BankAccountMapCRUD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty Map to store acct details : O(1)
			HashMap<Integer, BankAccount> accts = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : 1. Open A/C 2. View A/C summary 3. Funds Transfer 4 Close A/c 10.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // create
						System.out.println(
								"Enter a/c details : acctNo,  customerName, acctType, balance, createdOn(yyyy-MM-dd)");
						int acctNo=sc.nextInt();
						if(accts.containsKey(acctNo))
							throw new AccountHandlingException("Dup a/c no..");
						//=> dup not detected
						System.out.println(accts.put(acctNo, new BankAccount(acctNo, sc.next(),valueOf(sc.next().toUpperCase()) , 
								validateBalance(sc.nextDouble()),parse(sc.next()))));
						System.out.println("A/C created.....");
						break;
					case 10:
						exit = true;

						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// to read off pending tokens from scanner
				sc.nextLine();
			}
		}

	}

}
