package p2;

import p1.A;

public class D extends A {
	D() {
		//super(); : added implictly by javac : to invoke super cls's constr 
		System.out.println("D's state " + i + " " + j + " " + k + " " + l);
	}
}
