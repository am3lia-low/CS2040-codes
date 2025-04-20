package simple_java_prac_qns;

import java.util.Scanner;

public class LastFactDigit {

	public static void main(String[] args) {
		// wait
		// can u do factorial in java 0-0
		// nope
		
		// tests
		/*
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		int r = sc.nextInt();
		
		for(int x = 1; x <= q; x++) {
			int s = sc.nextInt();
			System.out.println(s);
		}
		*/
		
		fact();

	}
	
	public static void fact() {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int x = 1; x <= cases; x++) {
			int num = sc.nextInt();
			int res = 1;
			if(num == 0) {
				System.out.println(0);
			} else {
				for(int y = 2; y <= num; y++) {
					res *= y;
				}
				System.out.println(res%10);
			}
		}
				
	}

}
