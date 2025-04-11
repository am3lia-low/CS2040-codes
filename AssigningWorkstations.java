package labs;

import java.io.*;
import java.util.*;

// this question is giving class
/*
class Researcher {
	private int start;
	private int end;
	
	public int getStart() { return start; }
	public int getEnd() { return end; }
	
	public Researcher(int s, int d) {
		start = s;
		end = s+d;
	}
}

// i think somehow somewhere there is sorting involved
class TimeComparatorStart implements Comparator<Researcher> {
	public int compare(Researcher r1, Researcher r2) {
		if(r1.getStart() < r2.getStart()) return -1;
		else if(r1.getStart() > r2.getStart()) return 1;
		else {
			if(r1.getEnd() < r2.getEnd()) return -1;
			else if (r1.getEnd() > r2.getEnd()) return 1;
			else return 0;
		}
	}
}

// UPDATE: I THINK WE NEED TO SORT THEM BY END TIMING AS WELL
// because using only the former can really mess with the algo
// took me 2h to understand this now im sad :(

class TimeComparatorEnd implements Comparator<Researcher> {
	public int compare(Researcher r1, Researcher r2) {
		if(r1.getEnd() < r2.getEnd()) return -1;
		else if(r1.getEnd() > r2.getEnd()) return 1;
		else {
			if(r1.getStart() < r2.getStart()) return -1;
			else if (r1.getStart() > r2.getStart()) return 1;
			else return 0;
		}
	}
} */

// UPDATE UPDATE: time limit exceeded T-T
// what if we fuck the class cos i think the class is making this harder
// so that just makes our sort...normal sort
// omg class was the problem ;-;

// UPDATE x3:
// let me change the ArrayLists to Arr
// if array really don work i will suck it up ;-;

public class AssigningWorkstations {

	public static void main(String[] args) throws IOException {
		// must we really use pq ;-; i don't wanna
		// help we're starting so late the hints are out
		// good and bad ig
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		
		// info
		int ppl = Integer.parseInt(info[0]);
		int lockout = Integer.parseInt(info[1]) + 1; // since they all int anyway let's abuse that fact
		
		// researcher list
		int[] timingsStart = new int[ppl];
		int[] timingsEnd = new int[ppl];
		for(int x = 0; x < ppl; x++) {
			String[] Researcher = br.readLine().split(" ");
			int s = Integer.parseInt(Researcher[0]);
			int e = Integer.parseInt(Researcher[1]) + s;
			timingsStart[x] = s;
			timingsEnd[x] = e;
		}
		br.close();
		Arrays.sort(timingsStart); Arrays.sort(timingsEnd);
		
		// keeping track of usages
		// let's attempt my heap/pq denial
		int count = 0;
		int pointy = 0;
		for(int y = 0; y < ppl; y++) {
			int old = timingsEnd[y];
			for(int z = pointy; z < ppl; z++) {
				int nw = timingsStart[z];
				if(nw >= old && (nw - old) < lockout) {
					count++;
					pointy = z+1;
					break;
				}
			}
		}
		
		// output
		System.out.print(count);

	}

}
