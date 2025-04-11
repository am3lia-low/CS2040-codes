package labs;

import java.util.*;
import java.io.*;

public class WeakVertices {

	public static void main(String[] args) throws IOException {
		// ok at least they're not weighted or directed yet ;-;
		// the input unlocks my matrix trauma
		// adj list? yeah that's probably better
		// let's start with that
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		String info = "";
		while(!(info = br.readLine()).equals("-1")) { // does this work?
			int n = Integer.parseInt(info);
			boolean[] weak = new boolean[n];
			ArrayList<ArrayList<Integer>> graf = new ArrayList<ArrayList<Integer>>();
			
			// take in graph info
			// this O(n^2) ain't too good :/
			for(int x = 0; x < n; x++) {
				weak[x] = true;
				ArrayList<Integer> temp = new ArrayList<Integer>();
				String[] line = br.readLine().split(" ");
				// line by line
				for(int y = 0; y < n; y++) {
					if(line[y].equals("1")) {
						temp.add(y);
					}
				}
				graf.add(temp);
			}
			
			// checking weak vertices
			// going through the 1st edge (v1)
			for(int v1 = 0; v1 < n; v1++) {
				if(weak[v1]) {
					for(Integer v2 : graf.get(v1)) { // (v2) - (v1)
						for(Integer v3 : graf.get(v2)) { // (v3) - (v2) - (v1)
							// (v1) - (v3)
							if(graf.get(v3).contains(v1)) {
								weak[v1] = weak[v2] = weak[v3] = false;
								// update: i typo v3 as 3 and smoked through 4 test cases slay
							}
						}
					}
				}
			}
			
			// outputting the weaklings
			for(int x = 0; x < n; x++) {
				if(weak[x]) pr.print(x+" ");
			}
			pr.println();
		}
		br.close(); pr.flush();

	}

}
