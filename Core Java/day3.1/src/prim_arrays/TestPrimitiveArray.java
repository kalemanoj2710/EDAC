package prim_arrays;

import java.util.Scanner;

public class TestPrimitiveArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Hom many data points(double) to store?");
		double[] data;//0 objs , data : ref (array type : it can only refer to an array obj containing double vals
		//method loc var : stack , data : un initd
	//	System.out.println(data);
		data=new double[sc.nextInt()];//5
		for(double d : data)//d=data[0],d=data[1]....
			System.out.print(d+" ");
		System.out.println(data);
		System.out.println(data.getClass().getName());
		sc.close();

	}

}
