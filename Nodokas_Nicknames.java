package tha;

//A0258264X Kushioka Nodoka
import java.util.*;
import java.io.*;

class BSTVertex {
  BSTVertex parent;
  BSTVertex leftChild;
  BSTVertex rightChild;
  String key;
  int height;
  int size;

  public BSTVertex(String input) {
      this.parent = null;
      this.leftChild = null;
      this.rightChild = null;
      this.key = input;
      this.height = 0;
      this.size = 1;
  }
}

class nAVL {
  BSTVertex root;

  public nAVL() {
      this.root = null;
  }

  public int height(BSTVertex T) {
      if (T == null) {
          return 0;
      } else {
          return T.height;
      }
  }
  
  // hi, if i didn't delete these inorder()s, please help me delete thank ;-;
  public void inorder() {
		inorder(root);
	}
  
	public void inorder(BSTVertex T) {
	    if (T != null) {
	    	inorder(T.leftChild);
	    	System.out.print(T.key);
	    	inorder(T.rightChild);
	    }
	}

  public void updateHeight(BSTVertex T) {
      if (T != null) {
          T.height = Math.max(height(T.leftChild), height(T.rightChild)) + 1;
      }
  }

  public int size(BSTVertex T) {
      if (T == null) {
          return 0;
      } else {
          return T.size;
      }
  }

  public void updateSize(BSTVertex T) {
      if (T != null) {
          T.size = size(T.leftChild) + size(T.rightChild) + 1;
      }
  }

  public BSTVertex rotateLeft(BSTVertex T) {
      if (T.rightChild != null) {
          BSTVertex w = T.rightChild;
          w.parent = T.parent;
          T.parent = w;
          T.rightChild = w.leftChild;
          if (w.leftChild != null) {
              w.leftChild.parent = T;
          }
          w.leftChild = T;
          updateHeight(T);
          updateHeight(w);
          updateSize(T);
          return w;
      } else {
          return T;
      }
  }

  public BSTVertex rotateRight(BSTVertex T) {
      if (T.leftChild != null) {
          BSTVertex w = T.leftChild;
          w.parent = T.parent;
          T.parent = w;
          T.leftChild = w.rightChild;
          if (w.rightChild != null) {
              w.rightChild.parent = T;
          }
          w.rightChild = T;
          updateHeight(T);
          updateHeight(w);
          updateSize(T);
          return w;
      } else {
          return T;
      }
  }

  public int bf(BSTVertex T) {
      if (T == null) {
          return 0;
      } else {
          return height(T.leftChild) - height(T.rightChild);
      }
  }

  public BSTVertex balance(BSTVertex T) {
      if ((bf(T) == 2) && (bf(T.leftChild) >= 0) && (bf(T.leftChild) <= 1)) {
          T = rotateRight(T);
      } else if ((bf(T) == 2) && (bf(T.leftChild) == -1)) {
          T.leftChild = rotateLeft(T.leftChild);
          T = rotateRight(T);
      } else if ((bf(T) == -2) && (bf(T.leftChild) >= -1) && (bf(T.leftChild) <= 0)) {
          T = rotateLeft(T);
      } else if ((bf(T) == -2) && (bf(T.leftChild) == 1)) {
          T.rightChild = rotateRight(T.rightChild);
          T = rotateLeft(T);
      }
      return T;
  }

  public BSTVertex insert(BSTVertex T, String key) {
      if (T == null) {
    	  return (new BSTVertex(key));
      } else if (key.compareTo(T.key) < 0) {
          T.leftChild = insert(T.leftChild, key);
          T.leftChild.parent = T;
      } else {
          T.rightChild = insert(T.rightChild, key);
          T.rightChild.parent = T;
      }
      updateSize(T);
      updateHeight(T);
      return balance(T);
  }

  public void insert(String name) {
      this.root = insert(this.root, name);
  }

  public BSTVertex highestNode(BSTVertex T, String nickname) {
      if (T == null) {
          return null;
      }
      if (T.key.indexOf(nickname) == 0) {
          return T;
      }
      if (nickname.compareTo(T.key) < 0) {
          return highestNode(T.leftChild, nickname);
      } else {
          return highestNode(T.rightChild, nickname);
      }
  }

  public int Left(BSTVertex T, String nickname) {
      if (T == null) {
          return 0;
      }
      if (T.key.indexOf(nickname) == 0) {
          return 1 + Left(T.leftChild, nickname) + size(T.rightChild);
      } else {
          return Left(T.leftChild, nickname);
      }
  }

  public int Right(BSTVertex T, String nickname) {
      if (T == null) {
          return 0;
      }
      if (T.key.indexOf(nickname) == 0) {
          return 1 + Right(T.rightChild, nickname) + size(T.leftChild);
      } else {
          return Right(T.rightChild, nickname);
      }
  }

  public int count(String nickname) {
      if (highestNode(this.root, nickname) == null) {
          return 0;
      }
      return 1 + Left(highestNode(root, nickname).leftChild, nickname)
              + Right(highestNode(root, nickname).rightChild, nickname);
  }
}

public class Nodokas_Nicknames {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      int numNames = Integer.parseInt(br.readLine());
      
      HashMap<Character, nAVL> tree = new HashMap<Character, nAVL>();

      for (int i = 0; i < numNames; i++) {
          String name = br.readLine();

          if (tree.containsKey(name.charAt(0))) {
              tree.get(name.charAt(0)).insert(name);
          } else {
              nAVL toInsert = new nAVL();
              toInsert.insert(name);
              tree.put(name.charAt(0), toInsert);
          }
          tree.get('s').inorder();
      }

      int numNicknames = Integer.parseInt(br.readLine());

      for (int j = 0; j < numNicknames; j++) {
          String nickname = br.readLine();
          if (tree.containsKey(nickname.charAt(0))) {
              pw.write(tree.get(nickname.charAt(0)).count(nickname) + "\n");
          } else {
              pw.write(0 + "\n");
          }
      }

      pw.close();
      br.close();
  }
}