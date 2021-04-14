package var_args;
import static var_args.Utils.displyNames;

public class Tester {

	public static void main(String[] args) {
		//Different ways to  invoke method with var-args
		displyNames();
		System.out.println();
		displyNames(new Animal[] {new Dog(),new Cat()});
		System.out.println();
		displyNames(new Cat(),new Dog());
		

	}

}
