package p6;

public class Point2D {
	private int x, y;

	public Point2D(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

}
