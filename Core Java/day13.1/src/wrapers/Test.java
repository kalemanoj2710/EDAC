package wrapers;

public class Test {

	public static void main(String[] args) {
		Integer i1=new Integer(1234);//boxing 
		int data=i1.intValue();//un boxing
		i1=12345;//auto boxing(int ---> Integer : auto done by javac) : i1=Integer.valueOf(12345);
		String s="2345";
	//	s++;
		i1++;//auto un boxing(Integer-->int), inc , auto boxing
		System.out.println(i1);
		Double d1=123.456;//auto boxing
		double val=d1;//auto un boxing
		val=23.45f;//widening auto done by javac
	//	d1=23.45f;//float ---> Float(auto boxing) --XXXX----> Double
		d1=(double)23.45f;//Prog : float --> double  ---> Double auto boxing done by javac.
		Number n=123.456F;//float ---> Float (auto boxing) ----> Number (up casting)
		n=1234;
		n=12.3456;
		Object o=true;//boolean ---> Boolean (auto boxing) --->Object(upcasting)
		o=34.56;
		o=34;
		o='c';//char --> Character ---> Object
		Integer i2=127;
		Integer i3=127;
		System.out.println(i2==i3);//true
		System.out.println(i2.equals(i3));//true
		i2=128;
		i3=128;
		System.out.println(i2==i3);//false
		System.out.println(i2.equals(i3));//true

				
		
		
		

	}

}
