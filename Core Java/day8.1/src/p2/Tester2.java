package p2;

public class Tester2 {

	public static void main(String[] args) {
		Computable[] computables = { new Adder(), new Divider(), new Multiplier() };//4 : 1 array 
		//array : of Computable type of ref : referring to implementation cls instance
		for(Computable c : computables)//c =computables[0]...2
			System.out.println(c.compute(100, 20));//run time polymorphism (DMD)

	}

}
