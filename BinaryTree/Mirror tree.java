class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        
        invertTee(node);
        
        
    }
    
    Node invertTee(Node node){
        if(node == null){
            return node;
        }
        
        Node left = invertTee(node.left);
        Node right = invertTee(node.right);
        
        node.left = right;
        node.right = left;
        
        return node;
    }
}
