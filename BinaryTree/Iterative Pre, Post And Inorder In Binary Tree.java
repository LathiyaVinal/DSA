import java.util.Stack;

// Binary Tree operations in Java


/* 
============= OUTPUT ===============
Binary Tree : 12 25 30 37 50 62 70 75 87 
inOrder : 12 25 30 37 50 62 70 75 87 
preOrder : 50 25 12 37 30 75 62 70 87 
postOrder : 12 30 37 25 70 62 87 75 50 
============= OUTPUT ===============
*/


class BinarySearchTree {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    display(node.left);
    System.out.println(node.data);
    display(node.right);
  }

  public static Node constructTree(Integer[] preOrder) {
    Stack<Pair> stack = new Stack<>();

    Node root_nde = new Node(preOrder[0]);
    Pair pair_root = new Pair(root_nde, 1);
    stack.push(pair_root);

    for (int i = 1; i < preOrder.length; i++) {

      if (preOrder[i] != null) {
        Pair pair = stack.peek();

        Node new_node = new Node(preOrder[i]);
        Pair new_pair = new Pair(new_node, 1);

        if (pair.state == 1) {

          pair.node.left = new_node;
          pair.state++;
          stack.push(new_pair);

        } else if (pair.state == 2) {
          pair.node.right = new_node;
          pair.state++;
          stack.pop();
          stack.push(new_pair);
        }
      } else {
        Pair pair = stack.peek();
        pair.state++;
        if (pair.state == 3) {
          stack.pop();
        }
      }

    }

    return root_nde;

  }

  public static String inOrder = "";
  public static String preOrder = "";
  public static String postOrder = "";

  public static void get_In_Pre_Post_Order_Traversal_Iterative(Node root) {
    Stack<Pair> stack = new Stack<>();

    Pair pair_root = new Pair(root, 1);
    stack.push(pair_root);

    while (!stack.isEmpty()) {

      Pair pair = stack.peek();

      if (pair.state == 1) {

        // preOrder

        preOrder = preOrder + pair.node.data + " ";

        Node new_node = pair.node.left;
        if (new_node != null) {
          Pair new_pair = new Pair(new_node, 1);
          stack.push(new_pair);
        }

        pair.state++;

      } else if (pair.state == 2) {

        // in Order

        inOrder = inOrder + pair.node.data + " ";

        Node new_node = pair.node.right;
        if (new_node != null) {
          Pair new_pair = new Pair(new_node, 1);
          stack.push(new_pair);
        }
        pair.state++;
      } else {
        // post order

        postOrder = postOrder + pair.node.data + " ";

        stack.pop();
      }
    }

  }

  public static void main(String[] args) {

    Integer[] preOrderArr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
        null };

    Node root = constructTree(preOrderArr);

    display(root);

    get_In_Pre_Post_Order_Traversal_Iterative(root);

    System.out.println("inOrder : " + inOrder);
    System.out.println("preOrder : " + preOrder);
    System.out.println("postOrder : " + postOrder);

  }
}
