//////////// RECURSIVE SOLUTION //////////////////////
// time complexity : O(n), Space complexity : O(n)


class Solution
{
  ArrayList <Integer> output = new ArrayList<>();
    
	ArrayList <Integer> boundary(Node root)
	{
	    
	   output.add(root.data);
	   
	   printLeftBoundry(root.left);
	   printLeaves(root.left);
	   printLeaves(root.right);
	   printRightBoundry(root.right);
	   
	   return output;
    }
    
    public void printLeftBoundry(Node root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            output.add(root.data);
            printLeftBoundry(root.left);
        }else if(root.right != null){
            output.add(root.data);
            printLeftBoundry(root.right);
        }
    }
	
	public void printRightBoundry(Node root){
        if(root == null){
            return;
        }
        
        if(root.right != null){
            printRightBoundry(root.right);
            output.add(root.data);

        }else if(root.left != null){
            printRightBoundry(root.left);
            output.add(root.data);
        }
    }
    
    public void printLeaves(Node root){
        if(root == null){
            return;
        }
        
        printLeaves(root.left);
        if(root.left == null && root.right == null){
            output.add(root.data);
        }
        
        printLeaves(root.right);
    }
}
