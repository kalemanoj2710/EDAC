package p1;

public  class Adder implements Computable{
	@Override
	public double compute(double a,double b)
	{
		//imple class can DIRECTLY access i/f constants
		System.out.println("PI "+PI);
		return a+b;
	}

}
