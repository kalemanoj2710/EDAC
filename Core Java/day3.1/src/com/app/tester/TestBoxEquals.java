/*
1.4 Create a TestBox class , which allows user to supply 3 dimensions  as user i/ps via scanner. Create Box object & display its dimensions & display volume.
Add it in the package : com.app.tester
*/
package com.app.tester;

import java.util.Scanner;
import com.app.cdac.Box;

class TestBoxEquals {
	public static void main(String[] args) {
		// create sc instance to wrap std input stream : System.in
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st  Box Dims : w d h");
		Box b1= new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		// display box dims
		System.out.println(b1.getBoxDetails());
		// display volume
		System.out.println("Volume =" + b1.computeVolume());
		System.out.println("Enter 2nd  Box Dims : w d h");
		Box b2= new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		//print SAME or DIFFERENT
		System.out.println(b2.isEqual(b1)?"SAME":"DIFFERENT");
		//prompt for dims
		System.out.println("Enter offset dims from b1");
		Box b3=b1.createNewBox(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		System.out.println(b3.getBoxDetails());
	
		// close scanner , before terminating java app.
		sc.close();
	}
}