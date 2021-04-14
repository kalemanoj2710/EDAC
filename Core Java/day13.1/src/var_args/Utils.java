package var_args;

public class Utils {
//add a static method that can display names of all animals ranging from 0....n
	public static void displyNames(Animal...animals)
	{
		for(Animal a : animals)
			System.out.println(a.getName());
	}
}
