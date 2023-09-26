package algorithm01.sec01;

import java.util.Random;

public class ex02 {

	public static void main(String[] args) {
		int[] ages = {60, 50, 30, 20, 10};
		
		double[] weight = new double[5];
		weight[0] = 77.8;
		weight[1] = 45.5;
		weight[2] = 88.5;
		weight[3] = 99.5;
		weight[4] = 35.5;
		
		for(int i = 0; i < weight.length; i++) {
			System.out.println(ages[i] + " " + weight[i]);
		}
		
		for (double d : weight) {
			System.out.println(d);
		}
	
	Random r = new Random(100);
	
	int[] numbers = new int[1000];
	
	for(int i = 0; i < numbers.length; i++) {
		numbers[i] = r.nextInt(101);
		// Á¤¼ö +- 21 --> 0~100
	}
	for (int i = 0; i < numbers.length; i++) {
		System.out.println(i + ": " + numbers[i]);
	}
	}

}
