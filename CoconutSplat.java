package labs;

import java.util.*;

// class bc i can
// also the here are the 3 states for my personal ref
// 1. folded, 2. fist, 3. palm
class playerstate {
	private int num;
	private String state;
	
	public int getnum() {
		return num;
	}
	
	public String deadyet() {
		return state;
	}
	
	public playerstate(int n, String s) {
		this.num = n;
		this.state = s;
	}
}

public class CoconutSplat {

	public static void main(String[] args) {
		// getting info
		Scanner sc = new Scanner(System.in);
		var syb = sc.nextInt();
		var players = sc.nextInt();
		sc.close();
		
		// creating the group of people
		ArrayList<playerstate> group = new ArrayList<>();
		for(int i = 1; i <= players; i++) {
			group.add(new playerstate(i, "folded"));
		}
				
		// visualising gameplay
		int index = 0;
		while(group.size() > 1) {
			index = (index+syb-1)%group.size();
			playerstate unlucky_lah = group.get(index);
			String crack = group.get(index).deadyet();
			if(crack == "folded") {
				group.set(index, new playerstate(unlucky_lah.getnum(), "fist"));
				group.add(index, new playerstate(unlucky_lah.getnum(), "fist"));
			} else if(crack == "fist") {
				group.set(index, new playerstate(unlucky_lah.getnum(), "palm"));
				index += 1;
			} else if(crack == "palm"){
				group.remove(index);
			}
		}
		System.out.println(group.get(0).getnum());

	}

}
