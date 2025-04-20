package simple_java_prac_qns;

import java.util.Scanner;

public class StuckInATimeLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String word = "Abracadabra";
		for(int x = 1; x <= N; x++) {
			String s = Integer.toString(x);
			String chant = String.join(" ", s, word);
			System.out.println(chant);
		}

	}

}
