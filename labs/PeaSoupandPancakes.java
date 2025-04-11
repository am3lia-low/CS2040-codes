package labs;

import java.io.*;
import java.util.*;

public class PeaSoupandPancakes {

	public static void main(String[] args) throws IOException {
		 // tests
		/*
		 String test = "pea";
		 Scanner sc1 = new Scanner(System.in);
		 String food = sc1.nextLine();
		 boolean flag = food.matches("pea");
		 System.out.println(flag);
		System.out.print(true && false);
		*/
		System.out.println(checker());
		
	}
	
	public static String checker() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int x = 0; x < n; x++) {
			int k = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			boolean pea = false;
			boolean pan = false;
			for(int y = 0; y < k; y++) {
				String item = sc.nextLine();
				if(item.equals("pea soup")) pea = true;
				else if(item.equals("pancakes")) pan = true;
				
				if(pea && pan) {
					sc.close();
					return name;
				}
			}
		}
		sc.close();
		return "Anywhere is fine I guess";
	}

}
