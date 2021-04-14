package com.app.shapes;

/*
 * 3. Rectangle -- x,y,w,h
Method --public double area()
public String toString() : x, y , w h
 */
public class Rectangle extends BoundedShape {
	private int width, height;

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	//override area()

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rect "+super.toString()+" width="+width+" height="+height;
	}
	
	

}
