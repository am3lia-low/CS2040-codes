package tha;

import java.util.*;
import java.io.*;

// THE MAN, THE MYTH, THE NIGHTMARE: NICKNAMES
// dk if prof took it down but 1 guy decided to flex
// on piazza that he finish Nicknames. damn funny

// SO most obviously, there should be a class for for the AVL tree
// things it should have: 
/* - a Node class
 * 		- Node left, right & parent
 * 		- int size? yea that's probably impt // update: it okay nvm
 * 		- int height
 * 		- String data
 * 
 * 		public Node(String d) {
 * 			Nodes = null for now
 * 			data = d
 * 			height = 0
 * 			size = 1
 * 		}
 */

/* - the proper AVL class
 * 		- Node root
 * 		public AVL() { root = null; } // prof programmed it like that
 * 		- height 
 * 		- get balance factor(Node n)
 * 		- update height (for after the rotations/insertion)
 * 		- balance tree(Node n) (the 4 scenarios)
 * 		- right rotate(Node n)
 * 		- left rotate(Node n)
 * 		- inserting (prof used 2 inserts) // took me a while to understand why
 * 		- the search (searchmach) (prof used 2 again)
 * 			- sidenote: if == ? & else == : (just google it again later)
 * 
 * 		- do we need an in order traversal?
 * 		ugh yes we do i'm very confused
 * 		actually we don't need quite a few features in the BSTDemo
 * */

/* plotting my AVL with .compareTo()
 * it compares the strings lexicographically
 * so e.g. "jb" after "ja" : "jb".compareTo("ja") = 1
 * & "ja" before "jb" and stuff
 * 
 * SO
 * the tree will be
 * n.data.compareTo(name) > 0:
 * 	n.data AFTER name : name will go LEFT
 * n.data.compareTo(name) < 0: no dupes
 * 	n.data BEFORE name : name will go RIGHT
 * 
 * bonus
 * .indexOf() is just amazing
 * e.g. if nicks is a substr of nickson (from the head), o/p = 0
*/

// writing main(String[] args)
/* no multiple test cases right 0-0
 * hashmap with 1st char(so we can speed things up) -> AVL, let's name it fores
 * hashmap with nickname -> matches, let's name it matchy
 * 
 * the names come first so we might as well plop that in 1st
 * (what if we insert the nicknames into the trees?
 * ...i don't think it'll work since they're BSTs?)
 * forloop(intake names(full))
 * 	- we take the 1st char (ini)
 * 	- if ini in fores
 * 		- if no, insert to NEW AVL & put avl in fores
 * 		- if yes, insert into existing AVL
 * 
 * forloop(intake nicknames(nickers)) // will there ever be a String nickers = "nickers"?
 * 	- take 1st char (nic)
 * 	- int mach = 0
 * 	- if nic in fores
 * 		- if no, mach = 0
 * 		- if yes, if nickers in matchy
 * 			- yes, mach = matchy.get(nickers)
 * 			- no, matchy.put(nickers, fores.get(nic).searchmach(nickers)) or smth
 * 
 * print your outputs otw
 * */

class Node {
	Node left, right, parent;
	int height;
	String data;
	
	Node(String d) {
		Node left = null;
		Node right = null;
		Node parent = null;
		data = d; height = 0;
	}
}

class AVL {
	Node root;
	
	// they getting lost so i gotta look
	public void inorder() {
		inorder(root);
	}
	public void inorder(Node n) {
	    if (n != null) {
	    	inorder(n.left);
	    	System.out.print(n.data);
	    	inorder(n.right);
	    }
	}
	
	// i'm gonna insert & searchmach bc it's been bothering me abit
	// kickstarting the insertion from the root
	// insert(s)
	public void insert(String name) {
		root = insert(root, name);
	}
	
	public Node insert(Node n, String name) {
		if(n == null) {
			return new Node(name); // base case
		}
		else if(n.data.compareTo(name) > 0 ) {
			n.left = insert(n.left, name);
			n.left.parent = n;
		} else {
			n.right = insert(n.right, name);
			n.right.parent = n;
		}
		updheight(n);
		return bal(n);
	}
	
	// searchmach(s)
	// let's just put mach to be long. i give up trying int.
	// starting from the root same
	public long searchmach(String nickers) {
		long count = searchmach(root, nickers);
		return count;
	}
	
	public long searchmach(Node n, String nickers) {
		if(n == null) return 0; // base case
		else if(n.data.compareTo(nickers) < 0) {
			// name is shorter/before so no point
			// find in the longer/after names
			return searchmach(n.right, nickers);
		} else if(n.data.indexOf(nickers) == 0) {
			// its a match! congrats!
			// now get down there, left & right
			return searchmach(n.left, nickers) + searchmach(n.right, nickers) + 1;
		} else {
			// name is longer/after nickname
			// i don't really know a test case for this one
			// but uk, just in case
			// maybe we'll delete this and try it out? idk
			return searchmach(n.left, nickers);
		}
	}
	
	// shouldn't we put this in Node class?
	// it may get messy, i suspect
	// plus we can try that cool ? : thing
	public int height(Node n) { return n == null ? -1 : n.height; }
	
	public void updheight(Node n) {	if(n != null) n.height = Math.max(height(n.left), height(n.right)) + 1; }
	
	public int balfac(Node n) {	return n == null ? 0 : height(n.left) - height(n.right); }
	
	// oh god this was painful
	public Node rotateL(Node n) {
		if(n.right != null) {
			Node w = n.right;
			w.parent = n.parent;
			n.parent = w;
			n.right = w.left;
			if(w.left != null) w.left.parent = n;
			w.left = n;
			updheight(w); updheight(n);
			return w; // the new head
		} else { return n; }
	}
	
	public Node rotateR(Node n) {
		if(n.left != null) {
			Node w = n.left;
			w.parent = n.parent;
			n.parent = w;
			n.left = w.right;
			if(w.right != null) w.right.parent = n;
			w.right = n;
			updheight(w); updheight(n);
			return w;
		} else { return n; }
	}
	
	public Node bal(Node n) {
		if(balfac(n) >= 2) {
			// left right
			if(balfac(n.left) == -1) {
				n.left = rotateL(n.left);
			}
			// left left
			n = rotateR(n);
		}
		else if(balfac(n) <= -2) {
			// right left
			if(balfac(n.right) == 1) {
				n.right = rotateR(n.right);
			}
			// right right
			n = rotateL(n);
		}
		return n;
	}
	
	public AVL() { root = null; }
}

public class Nicknames {

	public static void main(String[] args) throws IOException {
		// oh god it took me 11 frigging hours to code the draft tree ToT
		
		// initialising
		HashMap<Character, AVL> fores = new HashMap<>();
		HashMap<String, Long> matchy = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// taking in the names
		int a = Integer.parseInt(br.readLine());
		
		for(int x = 0; x < a; x++) {
			String full = br.readLine();
			char ini = full.charAt(0);
			if(!fores.containsKey(ini)) {
				AVL tre = new AVL();
				fores.put(ini, tre);
			}
			fores.get(ini).insert(full);
			fores.get('s').inorder();
		}
				
		// taking in nicknames
		int b = Integer.parseInt(br.readLine());
		for(int y = 0; y < b; y++) {
			String nickers = br.readLine();
			char nic = nickers.charAt(0);
			long mach = 0;
			if(fores.containsKey(nic)) {
				if(matchy.containsKey(nickers)) mach = matchy.get(nickers);
				else {
					mach = fores.get(nic).searchmach(nickers);
					matchy.put(nickers, mach);
				}
			}
			System.out.println(mach);
		}

	}

}
