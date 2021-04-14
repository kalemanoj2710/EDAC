package arrays;

import java.util.Arrays;

public class Test2DArray {

	public static void main(String[] args) {
		double[][] data = new double[3][4];
		// display
		System.out.println("Addres of 1st array : holder array");
		System.out.println(data);
		System.out.println("Address of refs");
		for (double[] d : data)
			System.out.println(d);
		for (double[] d : data) //iterating over the 1st array
			for (double d1 : d)
				System.out.println(d1);
		// init the array
		int value = 1;
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++)
				data[i][j] = value++;
		// to display multi dim array contents
		System.out.println(Arrays.deepToString(data));

	}

}
