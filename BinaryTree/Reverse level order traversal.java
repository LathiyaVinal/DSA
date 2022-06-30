
//reverse level order traversal is same as level order traversal.
//But here add right node first and then left node in queue. ad parrallely add them into stack 
//Instead of direct printing value from queue left - right node, push them on to stack. 


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_level_order_traversal {
    
    public static class Node{
        int data;
        Node left, right;
        
        Node(int data){
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(40);
        root.left.left = new Node(30);
        root.left.right = new Node(45);
        root.left.left.left = new Node(20);
        root.left.right.right = new Node(46);
        root.left.left.right = new Node(35);
        root.right = new Node(55);
        root.right.left = new Node(52);
        root.right.right = new Node(57);
        
        reverseOrderTraverse(root);
    }
    
    public static void reverseOrderTraverse(Node root){
        Stack<Node> stack  =new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        stack.push(root);
        while(!queue.isEmpty()){
            Node nde = queue.poll();
            
            if(nde.right != null){
                queue.offer(nde.right);
                stack.push(nde.right);
            }
            if(nde.left != null){
                queue.offer(nde.left);
                stack.push(nde.left);
            }
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }
    }
}
