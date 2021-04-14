package strings;

public class Test3 {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = new String("abcd");
		String s3 = "abcd";
		String s4 = "ABCD";
		System.out.println(s1 == s2);// false
		System.out.println(s1 == s3);// true
		System.out.println(s1 == s4);// f
		System.out.println(s1.equals(s2));// t
		System.out.println(s1.equals(s3));// t
		System.out.println(s1.equals(s4));// f
		System.out.println(s1.equalsIgnoreCase(s4));// t
	}

}
