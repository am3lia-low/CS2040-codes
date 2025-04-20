package simple_java_prac_qns;

import java.util.Scanner;
import java.lang.Math;

public class NumberFun {

	public static void main(String[] args) {
		// wait dude
		// how do u even input 3 numbers at one shot
		/*
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[3];
		for(int i=0; i<3; i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i = 0; i<3; i++) {
			System.out.print(arr1[i]+" ");
		}
		*/
		// oooo
		// i love quora for many reasons
		
		// test runs
		/*
		System.out.println(5/3);
		System.out.println(Math.abs(9.0 - 16.0) == 7.0);
		double a1 = 9;
		double b1 = 16;
		double c1 = 7;
		System.out.println(Math.abs(a1 - b1) == c1);
		if(a1 - b1 == Math.abs(c1)) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int x = 1; x <= N; x++) {
			int[] arr = new int[3];
			for(int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
			}
			double a = arr[0];
			double b = arr[1];
			double c = arr[2];
			if(a+b == c || Math.abs(a - b) == c || a*b == c || a/b == c || b/a == c) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
			
		}
		sc.close();

	}

}
