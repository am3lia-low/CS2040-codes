package tha;

import java.io.*;

//let's get the linked list ptsd ball rolling
class stringnode {
	String cur;
	stringnode suc;
	stringnode tail;
	// do we need a pointer thing for preceding string?
	// update: no, but we need one to point a tail
		
	public void setsuc(stringnode s) {
		if(this.suc == null) {
			this.suc = s;
		}
		else {
			this.suc.setsuc(s);
		}
	}
		
	public stringnode(String c) {
		this.cur = c;
		this.suc = null;
	}
}

// but maybe if i create a LL the runtime errors will stop haunting me ;-;?
class linkstring {
	stringnode head;
	stringnode tail;
	int size = 0;
	
	public linkstring() {
	}
	
	public void add_sn(stringnode sn) {
		this.head = sn;
		this.tail = sn;
		size += 1;
	}
	
	public void add_ls(linkstring ls) {
		tail.setsuc(ls.head);
		this.tail = ls.tail;
		ls.head = null;
		size += ls.size;
	}
	
}

public class JoinStrings {

	public static void main(String[] args) throws IOException {
		// getting the info
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		linkstring[] words = new linkstring[count];
		for(int i = 0; i < count; i++) {
			linkstring temp = new linkstring();
			temp.add_sn(new stringnode(br.readLine()));
			words[i] = temp;
		}
		
		// arranging the strings
		int a = 0; // idk how relevant this is tho
		for(int j = 0; j < count-1; j++) {
			String[] indexes = br.readLine().split(" ");
			a = Integer.parseInt(indexes[0])-1;
			int b = Integer.parseInt(indexes[1])-1;
			words[a].add_ls(words[b]);
		}
		br.close();
		
		// putting them tgt for output
		PrintWriter pr = new PrintWriter(System.out);
		linkstring lst = words[a];
		stringnode next = lst.head;
		for(int k = 0; k < lst.size; k++) {
			pr.print(next.cur);
			next = next.suc;
		}
		
		// output
		pr.flush();
		pr.close();		

	}

}
