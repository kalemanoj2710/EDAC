package tester;

public class TestUncheckedException2 {

	public static void main(String[] args) {
		try {
			String s = "123";
			// javac DOES NOT force handling of the un checked excs
			System.out.println("int value : " + Integer.parseInt(s));
			int[] data = { 1, 2, 3, 4, 5 };
			System.out.println(data[40]);
			String s2 ="adfg";
			System.out.println(s2.charAt(0));
			int a = 100 / 0;
			System.out.println("result=" + a);
			System.out.println("end of try");
//		} catch (NumberFormatException e) {
//			System.out.println("1");
//		}
//		catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
//			System.out.println("2");
		}  catch (Exception e) {
			System.out.println("in catch-all");
			e.printStackTrace();
		}

		System.out.println("cntd....");

	}

}
