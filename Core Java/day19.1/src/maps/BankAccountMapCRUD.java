package maps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

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
			HashMap<Integer, BankAccount> accts = new HashMap<>();// init capa =16 Load Factor=0.75f
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Options : 1. Open A/C 2. Display  all accts  3.View A/C summary 4. Funds Transfer 5 Close A/c"
								+ "6 : Apply simple interest  7. Display customer names  8. Display accts sorted as per asc acct nos 10.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // create
						System.out.println(
								"Enter a/c details : acctNo,  customerName, acctType, balance, createdOn(yyyy-MM-dd)");
						int acctNo = sc.nextInt();
						if (accts.containsKey(acctNo))
							throw new AccountHandlingException("Dup a/c no..");
						// => dup not detected
						System.out.println(accts.put(acctNo, new BankAccount(acctNo, sc.next(),
								valueOf(sc.next().toUpperCase()), validateBalance(sc.nextDouble()), parse(sc.next()))));
						System.out.println("A/C created.....");
						break;

					case 2:
						System.out.println("All Accounts");
						for (BankAccount a : accts.values())
							System.out.println(a);
						break;
					case 3: // get acct summary --- i/p --acct number
						System.out.println("Enter acct no for checking a/c summary");
						BankAccount a = accts.get(sc.nextInt());// auto boxing , JVM : key's hashCode --derives bucket
																// id --empty
						// rets null o.w : invokes equals ---true => rets value ref , false(for all keys
						// in the SAME bucket) => rets null
						if (a == null)
							throw new AccountHandlingException("A/C not found : invalid a/c no");
						System.out.println("A/C summary " + a);
						break;
					case 4: // fund transfer
						System.out.println("Enter src dest acct no n transfer amount ");
						int srcAcctNo = sc.nextInt();
						int destAcctNo = sc.nextInt();
						double amount = sc.nextDouble();
						BankAccount src = accts.get(srcAcctNo);
						if (src == null)
							throw new AccountHandlingException("Src A/C not found : invalid a/c no");
						BankAccount dest = accts.get(destAcctNo);
						if (dest == null)
							throw new AccountHandlingException("Dest A/C not found : invalid a/c no");
						// => src n dest a/cs exists
						src.transferFunds(dest, amount);
						System.out.println("Finds transferred....");

						break;
					case 5:// close a/c
						System.out.println("Enter acct no for closing a/c");
						a = accts.remove(sc.nextInt());
						if (a == null)
							throw new AccountHandlingException("A/C not found : Can't close it!!!!!!");
						System.out.println("Closed a/c " + a);

						break;
					case 6:// Apply interest on on saving type of a/cs.
						System.out.println("Enter current interest rate ");
						double rate = sc.nextDouble();
						for (BankAccount a1 : accts.values())
							if (a1.getAcctType().equals(SAVING))
								a1.applyInterest(rate);
						System.out.println("Interest applied...");
						break;

					case 7:// Display customer names , whose a/c is created before a particular date
						System.out.println("Enter date (yyyy-MM-dd)");
						LocalDate date = parse(sc.next());
						System.out.println("Customer names , whose a/c created before : " + date);
						for (BankAccount a1 : accts.values())
							if (a1.getCreatedOn().isBefore(date))
								System.out.println(a1.getCustomerName());
						break;
					case 8:
						System.out.println("Sorted a/cs as per asc acct nos");
						// TreeMap(Map<? extends K,? extends V> map)
						TreeMap<Integer, BankAccount> sortedAccts = new TreeMap<>(accts);
						// In above stmt : JVM invokes : Natural ordering : key based criteria :
						// Integer's compareTo
						// display accts info
						for (BankAccount a1 : sortedAccts.values())
							System.out.println(a1);
						break;
					case 9:
						System.out.println("Sorted a/cs as per date n balance");
						//(List<BankAccount>)accts.values() => run time exc
						ArrayList<BankAccount> list=new ArrayList<>(accts.values());
						Collections.sort(list, new Comparator<BankAccount>() {

							@Override
							public int compare(BankAccount o1, BankAccount o2) {
								System.out.println("in compare....");
								// date n balance
								int ret = o1.getCreatedOn().compareTo(o2.getCreatedOn());
								if (ret == 0)
									return ((Double) o1.getBalance()).compareTo(o2.getBalance());
								return ret;
							}

						});
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
