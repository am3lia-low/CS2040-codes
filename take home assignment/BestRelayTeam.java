package tha;

import java.io.*;

//0: making a class so runners are easier to access
class Runner {
	private String name;
	private double first;
	private double second;
	
	public String getname() {
		return name;
	}
	
	public double get1() {
		return first;
	}
	
	public double get2() {
		return second;
	}
	
	public Runner(String name, double first, double second) {
		this.name = name;
		this.first = first;
		this.second = second;
	}
}

public class BestRelayTeam {

	public static void main(String[] args) throws IOException {
		// 1: getting runners details
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Runner[] peoples = new Runner[count];
		for(int x = 0; x < count; x++) {
			String[] list = br.readLine().split(" ");
			var n = list[0];
			double one = Double.parseDouble(list[1]), two = Double.parseDouble(list[2]);
			Runner guy = new Runner(n, one, two);
			peoples[x] = guy;
		}
		
		// 2: sorting runners
		for(int y = 1; y < count; y++) {
			boolean sortcheck = true;
			for(int z = 0; z < count-y; z++) {
				Runner curr = peoples[z];
				Runner back = peoples[z+1];
				if(curr.get2() > back.get2()) {
					sortcheck = false;
					Runner swop = curr;
					peoples[z] = back;
					peoples[z+1] = swop;					
				}
			}
			if(sortcheck) break;
		}
		
		
		// 3 trying combinations
		double testtime = 0;
		double besttime = 1288;
		Runner team[] = new Runner[4];
		Runner bestteam[] = new Runner[4];
		for(int z = 0; z < count; z++) {
			testtime = 0;
			testtime += peoples[z].get1();
			team[0] = peoples[z];
			int add = 1;
			for(int z1 = 0; z1 < 4; z1++) {
				if(z1 != z) {
					testtime += peoples[z1].get2();
					team[add] = peoples[z1];
					add += 1;
				}
				if(add == 4) break;
			}
			
			if(testtime < besttime) {
				besttime = testtime;
				System.arraycopy(team, 0, bestteam, 0, 4);
			}
		}
		
		
		// 3: output
		System.out.println(besttime);
		for(int a = 0; a < 4; a++) {
			System.out.println(bestteam[a].getname());
		}
	}

}

