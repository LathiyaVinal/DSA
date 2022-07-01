class Tree
{
    boolean isBalanced(Node root)
    {
	   
    
        if(root == null){
            return true;
        }
        
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        
        if((Math.abs(leftHeight - rightHeight) <= 1) &&
        isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    
    
    
    int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
