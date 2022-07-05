///////////////////////////////////////////////////////////////////////////////

Kth Smallest element 

//////////////////////////////////////////////////////////////////////////////


class Solution {

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);

        return ans;
    }

    int count = 0;
    int ans = -1;

    public void inOrderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, k);

        count++;

        if (count == k) {
            ans = root.val;
            return;
        }

        inOrderTraversal(root.right, k);
    }
}






///////////////////////////////////////////////////////////////////////////////

Kth larget element 

//////////////////////////////////////////////////////////////////////////////


class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        reverseInOrderTraversal(root, K);
        return ans;
    }
    
    int count = 0;
    int ans = -1;
    
    public void reverseInOrderTraversal(Node root, int k){
        
        if(root == null){
            return;
        }
        
        reverseInOrderTraversal(root.right, k);
        
        count++;
        if(count == k){
            ans = root.data;
        }
        
        reverseInOrderTraversal(root.left, k);
    }
}

