package com.app.tester;

import java.util.Scanner;

import com.app.cdac.Box;

public class TestCube {

	public static void main(String[] args) {
		//sc
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter side of a cube");
		Box cube=new Box(sc.nextDouble());
		System.out.println(cube.getBoxDetails());
		System.out.println("Volume "+cube.computeVolume());
		sc.close();
		

	}

}
