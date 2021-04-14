package com.app.shapes;
import static java.lang.Math.PI;
/*
 * 2. Circle -- x,y,radius
Method --public double area()
public String toString() : x, y , radius
 */
public class Circle extends BoundedShape {
	private double radius;
	public Circle(int x,int y,double radius) {
		super(x,y);
		this.radius=radius;
	}
	//override inherited area()
	@Override
	public double area()
	{
		return PI*radius*radius;
	}
	//override toString : to ret complete details of a circle
	@Override
	public String toString()
	{
		return "Circle "+super.toString()+" radius = "+radius;
	}
}
