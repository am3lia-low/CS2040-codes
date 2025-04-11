package labs;

import java.util.*;

public class T9Spelling {
	
	public static void main(String[] args) {
		// creating hashmap
		HashMap<Character, String> abts = new HashMap<Character, String>();
		abts.put(' ', "0");
		
		abts.put('a', "2");
		abts.put('b', "22");
		abts.put('c', "222");

		abts.put('d', "3");
		abts.put('e', "33");
		abts.put('f', "333");
		
		abts.put('g', "4");
		abts.put('h', "44");
		abts.put('i', "444");
		
		abts.put('j', "5");
		abts.put('k', "55");
		abts.put('l', "555");
		
		abts.put('m', "6");
		abts.put('n', "66");
		abts.put('o', "666");
		
		abts.put('p', "7");
		abts.put('q', "77");
		abts.put('r', "777");
		abts.put('s', "7777");
		
		abts.put('t', "8");
		abts.put('u', "88");
		abts.put('v', "888");
		
		abts.put('w', "9");
		abts.put('x', "99");
		abts.put('y', "999");
		abts.put('z', "9999");
		
		// translator
		var sc = new Scanner(System.in);
		var cases = sc.nextInt();
		sc.nextLine();
		for(int x = 1; x <= cases; x++) {
			String msg = sc.nextLine();
			char arr[] = msg.toCharArray();
			String ans = "";
			char prev = '0';
			char curr = '0';
			for(char d: arr) {
				curr = abts.get(d).charAt(0);
				if(prev == curr) ans += " ";
				prev = curr;
				ans += abts.get(d);
			}
			System.out.println("Case #" + x + ": " + ans);
		}
		sc.close();
	}
	
}
