package strings;

public class Test2 {

	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("hello");
		System.out.println("Contents "+sb1);
		System.out.println("len="+sb1.length()+" capa "+sb1.capacity());
		StringBuilder sb2=sb1.append("hi");
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));
		StringBuilder sb3=new StringBuilder("hello");
		System.out.println(sb1==sb3);
		System.out.println(sb1.equals(sb3));
	//	sb1.reverse();
		System.out.println(sb1);
		sb1.append(true).append(123).append(34.56f).append("fghgfhgfh");
		System.out.println(sb1);
		sb1.delete(0, sb1.length());
		System.out.println("Contents : "+sb1);
		System.out.println("len="+sb1.length()+" capa "+sb1.capacity());
		sb1.trimToSize();
		System.out.println("len="+sb1.length()+" capa "+sb1.capacity());
	
		

	}

}
