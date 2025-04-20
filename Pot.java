package simple_java_prac_qns;

import java.util.Scanner;
import java.lang.Math;

public class Pot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		for(int x = 1; x <= N; x++) {
			int val = sc.nextInt();
			sum += Math.pow(val/10, val%10);
		}
		System.out.println(sum);

	}

}
