package tester;

import static utils.EmpValidationConstraints.parseDate;
import static utils.EmpValidationConstraints.sdf;
import static utils.EmpValidationConstraints.validateAdharCardLocation;
import static utils.EmpValidationConstraints.validateEmpDetails;

import java.util.Date;
import java.util.Scanner;

import com.app.core.Emp;

public class TestEmps {

	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			Emp[] emps = new Emp[100];
			int counter = 0;
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Options : 1 Add Emp Details 2. Show 10.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter emp details : id name sal joindate(day-mon-yr) dept");
						Emp e = validateEmpDetails(emps, sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next());
						System.out.println("emp reg successful");
						emps[counter++] = e;
						System.out.println("Enter adhar card details : card_no date location");
						e.linkAdharCard(sc.next(), sdf.parse(sc.next()), validateAdharCardLocation(sc.next()));

						break;

					case 2:
						for (Emp e1 : emps)
							if (e1 != null)
								System.out.println(e1);

						break;
					case 3: System.out.println("Display emp ids whose adhar card date > specific date");
					System.out.println("Enter the date (day-mon-yr)");
					Date d1=parseDate(sc.next());
					for(Emp e1 : emps)
						if(e1 != null)
							if(e1.getCreationDate().after(d1))
								System.out.println(e1.getId());				
					
						break;
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
