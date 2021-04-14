package p6;

public class TestInterface {

	public static void main(String[] args) {
		Computable[] shapes= {new Circle(10, 20, 5.6),new Rectangle(50, 100, 10, 15)};
		for(Computable c : shapes) {
			System.out.println(c);//toString 
			System.out.println("Area ="+c.calcArea()+" Perimeter="+c.calcPerimeter());
		}

	}

}
