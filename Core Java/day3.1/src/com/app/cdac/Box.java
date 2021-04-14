package com.app.cdac;

public class Box {
	// state : instance vars : tight encapsulation : private
	private double width, height, depth;

	// add parameterized constr to init complete state of a box
	public Box(double w, double d, double height) {
		this.width = w;
		depth = d;
		this.height = height;
	}

	// add a constr to create a cube
	public Box(double side) {
		this(side, side, side);// invoking 3 param constr : constr chaining
	}

//Add a method to return box details in a string form
	public String getBoxDetails() {
		return "Box Dims " + width + " " + depth + " " + height;
	}

//Add a method to return computed volume of a box
	public double computeVolume() {
		return width * height * depth;
	}

	// add an instance method to chk the equality of boxes
	//anotherBox = b1 , this = b2
	public boolean isEqual(Box anotherBox) {
		return (this.width == anotherBox.width) 
				&& (height == anotherBox.height) && (depth == anotherBox.depth);
	}
	//add another method to return a new box having dims offset from the invoke box obj.
	//b1.createNewBox(...) : this => b1
	public Box createNewBox(double wOff,double dOff,double hOff)
	{
		Box tmp=new Box(this.width+wOff,depth+dOff,height+hOff);
		return tmp;//method rets ref of newly created box to the caller
	}

}
