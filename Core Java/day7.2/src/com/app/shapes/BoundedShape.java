package com.app.shapes;

/*
 * 1. BoundedShape -- x,y 
Method --public double area() : 0
public String toString() : x, y 
 */
public abstract class BoundedShape {
	private int x, y;

	public BoundedShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	//simply supply abstract method declaration :  area()
	public abstract double area();
	
	//override toString
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
	

}
