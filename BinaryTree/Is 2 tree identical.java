class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    return isBothTreeAreIndentical(root1, root2);
	}
	
	boolean isBothTreeAreIndentical(Node root1, Node root2){
	    if(root1 == null && root2 == null){
	        return true;
	    }
	    
	    if(root1 != null && root2 != null){
	        if(root1.data == root2.data){
	            return (isBothTreeAreIndentical(root1.left, root2.left) &&
	            isBothTreeAreIndentical(root1.right, root2.right));
	        }
	    }
	    return false;
	    
	}
	
}
