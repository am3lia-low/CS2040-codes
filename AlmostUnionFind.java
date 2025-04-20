package tha;

import java.io.*;
import java.util.*;

// how about let's start by making a class first

class neoUFDS {
	public int[] par;
	// update: idt hashmaps make much of a diff from arrayL
	// update: so apparently arraylists of arraylists don't work
	// bc their indexes are an absolute nightmare
	// array it is :/
	// update: TLE 	;-;  let me try hashsets
	public HashSet<Integer>[] groups;
	// u have no idea how much google went into this one line
	// and the one below
	public long[] sum;
	
	public int findSet(int i) {
		return par[i];
		// i realise that they don't actually ask for the parent
		// so it don't matter if the parent is wrong
	}
	
	public boolean isSameSet(int p, int q) { return findSet(p) == findSet(q); }
	
	public void SS(int p) {
		int a = findSet(p);
		int s1 = groups[a].size();
		long s2 = sum[a];
		System.out.println(s1+" "+s2);
	}
	
	public void Union(int p, int q) {
		if(isSameSet(p, q)) return;
		int a = findSet(p); int b = findSet(q);
		// optimise, though its O(N/2) either way ;-;
		if(groups[a].size() >= groups[b].size()) {
			for(int x: groups[b]) { // uni teaches us to google; change my mind
				groups[a].add(x);
				par[x] = a;
			}
			groups[b] = null; // does this help the memory? o-o
			sum[a] += sum[b];
		} else {
			for(int x: groups[a]) {
				groups[b].add(x);
				par[x] = b;
			}
			groups[a] = null;
			sum[b] += sum[a];
		}
	}
	
	public void Move(int p, int q) {
		if(isSameSet(p, q)) return;
		int a = findSet(p); int b = findSet(q);
		groups[a].remove(p);
		groups[b].add(p);
		par[p] = b;
		sum[a] -= p; sum[b] += p;
	}
	
	public neoUFDS(int n) {
		par = new int[n];
		sum = new long[n];
		groups = new HashSet[n];
		for(int y = 0; y < n; y++) {
			par[y] = y;
			sum[y] = y;
			groups[y] = new HashSet<Integer>();
			groups[y].add(y);
		}
	}
}

public class AlmostUnionFind {

	public static void main(String[] args) throws IOException {
		// ok so what ppl have said on piazza
		// infinite recursion happening in findSet (if array is too large)
		// do not sort the arraylist aft move and union set
		// long for sum
		// moving is the problem
		
		// update: it took me a WHILE to understand what multiple test cases meant ;-;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info = "";
		while((info = br.readLine()) != null && info.length()!=0) {
			String[] info1 = info.split(" ");
			int n = Integer.parseInt(info1[0])+1; // bc java starts from 0 ((yay!))
			int m = Integer.parseInt(info1[1]);
			neoUFDS uu = new neoUFDS(n);
			
			for(int x = 0; x < m; x++) {
				String[] nums = br.readLine().split(" ");
				int func = Integer.parseInt(nums[0]);
				if(func == 1) {
					int p = Integer.parseInt(nums[1]);
					int q = Integer.parseInt(nums[2]);
					uu.Union(p, q);
				} else if(func == 2) {
					int p = Integer.parseInt(nums[1]);
					int q = Integer.parseInt(nums[2]);
					uu.Move(p, q);
				} else {
					int p = Integer.parseInt(nums[1]);
					uu.SS(p);
				}
			}
		}
		br.close();

	}

}
