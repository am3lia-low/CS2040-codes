package simple_java_prac_qns;

import java.lang.String;
import java.util.Scanner;

public class Autori {

	public static void main(String[] args) {
		// i can't tell if its satirical but one guy ranted how he's scared of cs2040 bc he got A- for cs1010j or smth
		// me with my B in cs1010s: -
		// anyway
		
		// dude i have no idea if they want a method or
		// the plain code itself
		
		// tests
		String str = "rest";
		int len = str.length();
		System.out.println(len);
		char ch1 = str.charAt(1);
		System.out.println(ch1);
		System.out.println(Character.isUpperCase(ch1));
		char ch2 = 'l';
		
		String st1 = Character.toString(ch1);
		String st2 = Character.toString(ch2);
		String res = String.join("", st1, st2);
		System.out.println(res);
		
		Scanner sc = new Scanner(System.in);
		String sample = sc.nextLine();
		conv(sample);
	}
	
	// method way
	
	public static void conv(String names) {
		int len = names.length() - 1;
		String res = "";
		for(int x = 0; x <= len; x++) {
			char ch = names.charAt(x);
			if(ch == '-') {
				continue;
			} else if(Character.isUpperCase(ch)) {
				String st = Character.toString(ch);
				res = String.join("", res, st);
			} else {
				continue;
			}
		}
		System.out.println(res);
	}
	

}

// DUDE IT WORKS IM HAPPY EEEEE
