package nested_classes;

public class Outer2 {
	private int i=100;

	
	class Inner2
	{
		private int i=200;

		
		void show(int i) //i=300
		{
			System.out.println(i);//300
			//200
			System.out.println(this.i);
			//100
			System.out.println(Outer2.this.i);
		}
		
	}

}
