package nested_classes;

public class Outer {
	private int i;
	private static int j;
	//static init block
	static {
		j=100;
	}
	//constr
	public Outer(int i) {
		super();
		this.i = i;
	}
	//static method
	public static void show()
	{
		System.out.println("Outer's show : static member "+j);
		//which members of inner class
		System.out.println("Inner's members : "+Inner.b);
		// a : Inner's non static data
		//create instance of the outer cls
		Outer outer=new Outer(111);
		Outer.Inner inner=outer.new Inner(345);	
		inner.showInner();
	}
	//Outer's non static method : 
	public void display()
	{
		System.out.println("Outer's display : non static "+i+" "+j);
		System.out.println("Inner's members "+Inner.b);
		//a : inner's non static : instance of inner class
		Inner in=new Inner(123);
		System.out.println(in.a);
		
		
	}
	//nested class : non static nested class : inner class
	class Inner
	{
		//data members  : non static
		private int a;
	//	private static int b;
		private static final int b=200;
//		static {
//			b=200;
//		}
		//static methods : illegal
//		static void test()
//		{
//			
//		}
		public Inner(int a) {
			super();
			this.a = a;
		}
		//non static method : YES
		//it can access : i , j ,a ,b : all
		public void showInner()
		{
			System.out.println("show inner "+i+" "+j+" "+a+" "+b);
		}
		
	}
	

}
