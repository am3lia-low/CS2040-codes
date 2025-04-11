package labs;

import java.util.*;

class NameComparator implements Comparator<String> {
	public int compare(String n1, String n2) {
		return n1.substring(0, 2).compareTo(n2.substring(0, 2));
	}
}

public class SortOfSorting {

	public static void main(String[] args) {
		// honestly the problem is with the iteration of test cases lol
		Scanner sc = new Scanner(System.in); // i lazy
		while(true) {
			int count = sc.nextInt();
			// check count first
			if(count == 0) {
				break;
			} else {
				// take in all the names
				ArrayList<String> namelist = new ArrayList<>();
				sc.nextLine();
				for(int j = 0; j < count; j++) {
					String name = sc.nextLine();
					namelist.add(name);
				}
				//sort
				Collections.sort(namelist, new NameComparator());
				// print all out
				for(int k = 0; k < namelist.size()-1; k++) {
					System.out.println(namelist.get(k));
				}
				System.out.println(namelist.get(namelist.size()-1) + '\n');
			}
		}
		sc.close();

	}

}
