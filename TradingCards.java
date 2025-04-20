package tha;

import java.io.*;
import java.util.*;

// creating card type class, bc I don't really like nested arrays
class CardType {
	// wait... will the prices ever be decimals? ok let's assume not
	// update: changed int to long cuz apparently a guy on piazza w the same algo kenna probs
	private long losemoney;
	private long earnmoney;
	
	// getters
	public long getbuy() {return losemoney;}
	public long getsell() {return earnmoney;}
	
	// class creator thing
	public CardType(long b, long s) {
		this.losemoney = b;
		this.earnmoney = s;
	}
}

// sort the cards using comparator, bc bubble no work ;-;
class CardComparator implements Comparator<CardType> {
	public int compare(CardType c1, CardType c2) {
		long one = c1.getbuy() + c1.getsell();
		long two = c2.getbuy() + c2.getsell();
		if(one < two) return -1;
		else if(one > two) return 1;
		else {
			if(c1.getbuy() < c2.getbuy()) return -1;
			else if (c1.getbuy() > c2.getbuy()) return 1;
			else return 0;
		}
	}
}

public class TradingCards {
	
	public static void main(String[] args) throws IOException {
		// getting all the cards
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		
		// getting cardcount for each type
		int count = Integer.parseInt(info[0]);
		int types = Integer.parseInt(info[1]);
		int[] cardcount = new int[types+1];
		String[] allcards = br.readLine().split(" ");
		for(int x = 0; x < count; x++) {
			int card = Integer.parseInt(allcards[x]);
			cardcount[card-1]++;
		}
		
		// getting card money info & setting classes
		ArrayList<CardType> cardinfos = new ArrayList<>();
		for(int y = 0; y < types; y++) {
			String[] buysell = br.readLine().split(" ");
			int c = cardcount[y];
			long b = (2-c) * Integer.parseInt(buysell[0]);
			long s = c * Integer.parseInt(buysell[1]);
			CardType cards = new CardType(b, s);
			cardinfos.add(cards);
		}	
		
		// sort them
		cardinfos.sort(new CardComparator());
		
		// "let the buying begin" - Sejanus Plinth, tbosas
		long profit = 0;
		int combos = Integer.parseInt(info[2]);
		for(int b = 0; b < combos; b++) profit -= cardinfos.get(b).getbuy();
		for(int c = combos; c < types; c++) profit += cardinfos.get(c).getsell();
		
		System.out.println(profit);
	}

}
