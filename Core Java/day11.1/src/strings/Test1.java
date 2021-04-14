package strings;

public class Test1 {

	public static void main(String[] args) {
		String s="Hello Strings, ! String handling is easy in java....";
		System.out.println(s.charAt(0)+" "+s.charAt(s.length()-1));
		System.out.println(s.contains("handling565"));
		System.out.println(s.substring(0,5));
		System.out.println(s.indexOf('a')+" "+s.lastIndexOf('a'));
		System.out.println(s.matches(".*easy.*"));
		System.out.println("abc".compareTo("xyz"));//Comparable i/f : compareTo : > 0 , or 0 or < 0

	}

}
