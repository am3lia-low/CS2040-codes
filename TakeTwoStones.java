package simple_java_prac_qns;

import java.util.Scanner;

public class TakeTwoStones {

	public static void main(String[] args) {
		// wait so basically
		// alice and bob are just too free
		// they decide to NOT count the stones
		// but make a damn game out of it
		// cool
		
		Scanner sc = new Scanner(System.in);
		int stones = sc.nextInt();
		winner(stones);

	}
	
	public static void winner(int a) {
		if(a%2 == 1) {
			System.out.println("Alice");
		} else {
			System.out.println("Bob");
		}
	}

}
