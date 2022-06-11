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

    public static int getHeightOfTree(Node root){

        if(root == null){
            return -1; 
            // -1 because we are calculating size of edges, 
            // if need to calculate size of nodes then return 0. 
        }

        int leftheight = getHeightOfTree(root.left);
        int rightheight = getHeightOfTree(root.right);

        return Math.max(leftheight, rightheight) + 1; // 1 added for node itself
    }

    public static int getTotalSumOfTree(Node root){
        if(root == null){
            return 0; 
        }

        int leftSum = getTotalSumOfTree(root.left);
        int rightSum = getTotalSumOfTree(root.right);

        return leftSum + rightSum + root.data; // 1 added for node itself
    }

    public static int getMaxSumOfTree(Node root){
        if(root == null){
            return Integer.MIN_VALUE; 
        }

        int leftSum = getMaxSumOfTree(root.left);
        int rightSum = getMaxSumOfTree(root.right);

        return Math.max(root.data, Math.max(leftSum, rightSum));
    }

    public static int getMinSumOfTree(Node root){
        if(root == null){
            return Integer.MAX_VALUE; 
        }

        int leftSum = getMinSumOfTree(root.left);
        int rightSum = getMinSumOfTree(root.right);

        return Math.min(root.data, Math.min(leftSum, rightSum));
    }

    public static int getTotalNodesOfTree(Node root){
        if(root == null){
            return 0;
        }

        int leftNodesCount = getTotalNodesOfTree(root.left);
        int rightNodesCount = getTotalNodesOfTree(root.right);

        return leftNodesCount + rightNodesCount + 1;
    }


    public static void main(String[] args) {

        Integer[] preOrder = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Node root = constructTree(preOrder);

        display(root);

        int height = getHeightOfTree(root);
        System.out.println("Height of tree : " + height);

        int total_sum = getTotalSumOfTree(root);
        System.out.println("Total sum of tree : " + total_sum);

        int max_sum = getMaxSumOfTree(root);
        System.out.println("Maximum sum : " + max_sum);

        int min_sum = getMinSumOfTree(root);
        System.out.println("Minimum sum : " + min_sum);

        int total_node = getTotalNodesOfTree(root);
        System.out.println("Total nodes : " + total_node);
    }
}
