package test_date;

import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.*;
import java.util.Scanner;

public class TestLocalDate {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter Birth Date (yr-mon-day)");
			LocalDate dob=parse(sc.next());//string ---> LocalDate
			LocalDate curntDate=now();
			int ageInYrs=Period.between(dob, curntDate).getYears();
			System.out.println("Age "+ageInYrs);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
