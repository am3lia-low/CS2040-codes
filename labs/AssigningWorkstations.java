package labs;

import java.io.*;
import java.util.*;

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

class TimeComparator implements Comparator<Researcher> {
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

public class AssigningWorkstations {

	public static void main(String[] args) throws IOException {
		// sigh
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		
		// info
		int ppl = Integer.parseInt(info[0]);
		int lockout = Integer.parseInt(info[1]);
		
		// researcher list
		PriorityQueue<Researcher> timings = new PriorityQueue<Researcher>(ppl, new TimeComparator());
		for(int x = 0; x < ppl; x++) {
			String[] r = br.readLine().split(" ");
			int s = Integer.parseInt(r[0]);
			int d = Integer.parseInt(r[1]);
			timings.add(new Researcher(s, d));
		}
		
		// allocations
		// they recommended two heaps right
		PriorityQueue<Integer> computers = new PriorityQueue<>();
		int count = 0;
        for(int y = 0; y < ppl; y++) {
        	int nw = timings.peek().getStart();
        	while(computers.size() > 0) {
        		int old = computers.peek();
        		if((nw - old) > lockout) {
        			computers.poll();
        		} else break;
        	}
        	
        	if(computers.size() > 0) {
        		int old = computers.peek();
        		if (nw >= old && (nw - old) <= lockout) {
        			computers.poll();
            		count++;
        		}
        	}
        	computers.add(timings.poll().getEnd());
        }
        // im so tired ;-;
        
        System.out.print(count);

	}

}
