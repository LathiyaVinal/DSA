import java.util.*;

public class Tree_construct_from_PreOrder_array {

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

    public static void main(String[] args) {

        Integer[] preOrder = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

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

        display(root_nde);
    }
}
