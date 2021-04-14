package tester;

public class TestFinally3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1");
		try {
			testMe();
			System.out.println("back in main");
		} catch (NullPointerException e) {
			System.out.println("in main's NPE  " + e);//name of exc class : err mesg
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over..");

	}

	private static void testMe()   {
		try {
			System.out.println("in meth's try");
			String[] ss = { "aa", "bb" };
			System.out.println(ss[2]);
			boolean flag = false;
			if (flag)
				return;
			System.out.println("end of try");
		} finally {
			System.out.println("in meth's finally");
		}
		System.out.println("meth end");
	}

}
