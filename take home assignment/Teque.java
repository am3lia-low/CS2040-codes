package tha;

import java.io.*;

// i wonder if u can use array to implement this
// lets die finding out
class struct {
	// starting from the end for front and opposite for back
	// won't help bc u need to insert stuff in the middle
	int[] front = new int[1000000];
	int[] back = new int[1000000];
	int indexF = 500000, indexB = 500000;
	int sizeF = 0, sizeB = 0;
	
	// when equal, prioritise putting in the front first, bc k+1/2
	// ((also bc the other way doesn't work ;-;))
	public void push_middle(int a) {
		if(sizeF == sizeB) {
			front[indexF + sizeF] = a;
			sizeF ++;
		} else {
			indexB --;
			back[indexB] = a;
			sizeB ++;
		}
	}
	
	public void push_back(int a) {
		if(sizeF == sizeB) {
			back[indexB + sizeB] = a;
			front[indexF + sizeF] = back[indexB];
			indexB ++; sizeF ++;
		} else {
			back[indexB + sizeB] = a;
			sizeB ++;
		}
	}
	
	public void push_front(int a) {
		if(sizeF == sizeB) {
			indexF --;
			front[indexF] = a;
			sizeF ++;
		} else {
			indexF --;
			front[indexF] = a;
			indexB --;
			back[indexB] = front[indexF + sizeF];
			sizeB ++;
		}
	}
	
	public int get(int i) {
		if(i < sizeF) { return front[indexF + i]; }
		else { return back[indexB + i - sizeF]; }
	}
	
	struct(){} // this looks so anti-climatic
}


public class Teque {
	
	public static void main(String[] args) throws IOException {
		// retrieving info
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		int count = Integer.parseInt(br.readLine());
		struct teq = new struct();
		for(int i = 0; i < count; i++) {
			String[] info = br.readLine().split(" ");
			String func = info[0];
			int a = Integer.parseInt(info[1]);
			
			// following funcmands
			if(func.equals("push_middle")) { teq.push_middle(a); }
			else if(func.equals("push_back")) { teq.push_back(a); }
			else if(func.equals("push_front")) { teq.push_front(a); }
			else if(func.equals("get")) { pr.println(teq.get(a)); }
		}
		
		// output
		pr.flush();
		pr.close();

	}

}
