package tester;

import static utils.EmpValidationConstraints.*;

import static utils.EmpValidationConstraints.validateAdharCardLocation;
import static utils.EmpValidationConstraints.validateEmpDetails;
import static java.time.LocalDate.*;

import java.time.LocalDate;
import static utils.CollectionUtils.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.core.Emp;

public class TestEmps {

	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<Emp> emps = new ArrayList<>();// size =0 , capa=10

			boolean exit = false;
			while (!exit) {
				try {
					System.out.println(
							"Options : 1 Add Emp Details 2. Show All Emps' deatils 3. Fetch Emp details Summary"
									+ "4 : Link Adhar Card 10.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter emp details : id name sal joindate(yr-mon-day) dept");
						Emp e = validateEmpDetails(emps, sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next());
						// add emp details to AL
						emps.add(e);
						System.out.println("emp reg successful");
						break;

					case 2:
						for (Emp e1 : emps)// for-each iterates from 1st elem to last elem (size)
							System.out.println(e1);
						break;
					case 3: // Fetch Emp details Summary
						System.out.println("Enter Emp id n name");
						System.out.println("Emp Details " + checkIfExists(emps, sc.nextInt(), sc.next()));
						break;

					case 4: // 4. Assign adhar card details to emp
						// i/p : id , name n adhar card details
						System.out.println("Enter Emp id n name");
						Emp emp = checkIfExists(emps, sc.nextInt(), sc.next());
						// => valid emp
						System.out.println("Enter Adhar Card Details : no date(yr-mon-day) location");
						emp.linkAdharCard(sc.next(), parse(sc.next()), validateAdharCardLocation(sc.next()));
						System.out.println("adhar card linked....");
						break;
					case 5:// . Change Adhar Card no
						// i/p id , name n new Adhar Card no
						System.out.println("Enter Emp id n name for changing adhar card no");
						emp = checkIfExists(emps, sc.nextInt(), sc.next());
						// => valid emp
						emp.setEmpAdharCardNumber(sc.next());						
						break;
//					case 3:
//						System.out.println("Display emp ids whose adhar card date > specific date");
//						System.out.println("Enter the date (day-mon-yr)");
//						LocalDate d1 = parseDate(sc.next());
//						for (Emp e1 : emps)
//							if (e1 != null)
//								if (e1.getCreationDate().isAfter(d1))
//									System.out.println(e1.getId());
//
//						break;
					case 10:
						exit = true;

						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// to read off all pending tokens from Scaner's buffer : till end of line
				sc.nextLine();
			}
		}
	}

}
