package labs;

import java.io.*;
import java.util.*;

// i'm just gonna use long for everything here bc some guy in piazza had overflows ;-;
// update: i need to reverse the order of the PQ oop
// update update: turns out, we don't need any comparator classes

public class KattisQuest {

	public static void main(String[] args) throws IOException {
		// let's start with by initialising stuff
		PrintWriter pr = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		TreeMap<Long, PriorityQueue<Long>> twee = new TreeMap<>();
		
		// taking in info
		for(int x = 0; x < count; x++) {
			String[] line = br.readLine().split(" ");
			String word = line[0];
			
			// add
			if(word.equals("add")) {
				long e = Long.parseLong(line[1]);
				Long g = Long.parseLong(line[2]);
				if(!twee.containsKey(e)) {
					twee.put(e, new PriorityQueue<Long>(Collections.reverseOrder()));
				}
				twee.getOrDefault(e, new PriorityQueue<Long>(Collections.reverseOrder())).add(g);
				// i have a bad feelin' this will drag time idk
				// update: rightfully so
			}
			
			// query
			if(word.equals("query")) {
				long energy = Long.parseLong(line[1]);
				long gold = 0;
				Long eng = twee.floorKey(energy);
				while(energy > 0 && eng != null) {
					PriorityQueue<Long> q = twee.getOrDefault(eng, new PriorityQueue<Long>(Collections.reverseOrder()));
					energy -= eng;
					gold += q.poll();
					if(q.isEmpty()) twee.remove(eng);
					else twee.put(eng, q);
					eng = twee.floorKey(energy);
				}
				pr.println(gold);
			}
		}
		
		br.close();
		
		// output
		pr.flush();
		pr.close();
		
	}

}
