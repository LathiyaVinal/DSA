class Solution {

    public boolean isSymmetric(TreeNode root) {
      if(root == null){
        return false;
      }
      return isMirrorOfTwoString(root, root);
    }

    public boolean isMirrorOfTwoString(TreeNode tree1, TreeNode tree2) {
      
      if (tree1 == null && tree2 == null) {
            return true;
        }
      
      
        if (tree2 != null && tree1 != null) {
            if (tree1.val == tree2.val) {
                
              return (isMirrorOfTwoString(tree1.left, tree2.right) 
                      && isMirrorOfTwoString(tree1.right, tree2.left));
            }
        }
      return false;
    }
}
