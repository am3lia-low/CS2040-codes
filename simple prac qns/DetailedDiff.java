package simple_java_prac_qns;

import java.util.Scanner;

public class DetailedDiff {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int x = 0; x < n; x++) {
			String ln1 = sc.nextLine();
			String ln2 = sc.nextLine();
			String ln3 = "";
			int len = ln2.length();
			for(int y = 0; y<len; y++) {
				if(ln1.charAt(y) == ln2.charAt(y)) {
					ln3 = String.join("", ln3, ".");
				} else {
					ln3 = String.join("", ln3, "*");
				}
			}
			System.out.println(ln1);
			System.out.println(ln2);
			System.out.println(ln3);
		}
		
	}

}
