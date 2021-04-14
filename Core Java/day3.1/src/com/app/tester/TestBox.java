/*
1.4 Create a TestBox class , which allows user to supply 3 dimensions  as user i/ps via scanner. Create Box object & display its dimensions & display volume.
Add it in the package : com.app.tester
*/
package com.app.tester;

import java.util.Scanner;
import com.app.cdac.Box;

class TestBox {
	public static void main(String[] args) {
		// create sc instance to wrap std input stream : System.in
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter BOx Dims : w d h");
		Box b1;
		b1 = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		// display box dims
		System.out.println(b1.getBoxDetails());
		// display volume
		System.out.println("Volume =" + b1.computeVolume());
		// close scanner , before terminating java app.
		sc.close();
	}
}