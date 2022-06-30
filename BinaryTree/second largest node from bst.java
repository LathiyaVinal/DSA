
//largest node is the right most node of tree. 
//to find second largest node, we have to find largest node and check 
//if largest node have left subtree, then find largest node from that tree, will give second largest node. 
//if largest node's left and right child are null, then its parent is second largest node. 




package com.vinalcareer.newton.mavenproject1;

/**
 *
 * @author Vinal Lathiya
 */
public class Second_Largest {

    Node root;

    class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public void insert(int data) {
        this.root = this.insertRec(this.root, data);
        System.out.println("root : " + this.root.data);
    }

    /* A utility function to insert a new node with given
    key in BST */
    Node insertRec(Node node, int data) {
        /* If the tree is empty, return a new node */
        
        if(node == null){
            root = new Node(data);
            return root;
        }
        
        if(data < node.data){
            node.left = insertRec(node.left, data);
        }else{
            node.right = insertRec(node.right, data);
        }
        
     
        return node;
    }

    static Node getLargest(Node node) {
        if (node.right != null) {
            return getLargest(node.right);
        }
        return node;
    }

    public static Node getSecondLargest(Node node) {

        // we are looking at the right-most element 
        // (aka largest) and it has a left child
        // so we want the largest element in its left child
        if (node.right == null && node.left != null) {
            return getLargest(node.left);
        }

        // we are looking at the parent of the largest element
        // and the largest element has no children
        // so this is the node we want
        if (node.right != null
                && node.right.left == null
                && node.right.right == null) {
            return node;
        }

        // recurse on the right child until we match
        // one of the above cases
        return getSecondLargest(node.right);
    }

    public static void main(String[] args) {
        Second_Largest tree = new Second_Largest();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(getSecondLargest(tree.root).data);
    }
}
