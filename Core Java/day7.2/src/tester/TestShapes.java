package tester;

import com.app.shapes.BoundedShape;
import com.app.shapes.Circle;
import com.app.shapes.Rectangle;

public class TestShapes {

	public static void main(String[] args) {
	//	BoundedShape anyShape=new BoundedShape(1,2);
		BoundedShape[] shapes= {new Circle(10, 20, 10.5),new Rectangle(50, 100, 10, 20)};//3 objects
		for(BoundedShape s : shapes) {
			System.out.println(s);//info 
			//display area : no down casting
			System.out.println("Area "+s.area());
		}

	}

}
