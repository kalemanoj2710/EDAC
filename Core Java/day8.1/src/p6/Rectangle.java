package p6;

public class Rectangle extends Point2D implements Computable {
	private int length,breadth;
	

	public Rectangle(int x, int y, int length, int breadth) {
		super(x, y);
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return length*breadth;
	}

	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length+breadth);
	}

	@Override
	public String toString() {
		return "Rectangle "+super.toString()+" [length=" + length + ", breadth=" + breadth + "]";
	}
	

}
