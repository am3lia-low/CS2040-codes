package labs;

import java.io.*;
import java.util.*;

public class Conformity {

	public static void main(String[] args) throws IOException {
		// y'know what will be good for this?
		// hashmaps !! yayy
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		HashMap<String, Integer> courses = new HashMap<>();
		int max = 1;
		
		sc.nextLine();
		for(int x = 0; x < count; x++) {
			// getting the key (course code)
			ArrayList<Integer> frosh = new ArrayList<>();
			String combi = "";
			for(int y = 0; y < 5; y++) { frosh.add(sc.nextInt()); }
			// would putting the bigger int uprfront make hashing faster?
			// let's see
			Collections.sort(frosh, Collections.reverseOrder());
			for(int z = 0; z < 5; z++) { combi += Integer.toString(frosh.get(z)); }
			
			// putting key into hashmap for count
			// update: let's take note of the max as well
			if(courses.containsKey(combi)) {
				int num = courses.get(combi) + 1;
				courses.put(combi, num);
				if(num > max) max = num;
				System.out.print(max);
			} else courses.put(combi, 1);
		}
		sc.close(); // forgot to close
			
		// get the count of popular courses
		int pop = 0;
		for(Map.Entry m: courses.entrySet()) {
			if(courses.get(m.getKey()) == max) pop += max;
		}
		
		// output
		System.out.print(pop);

	}

}
