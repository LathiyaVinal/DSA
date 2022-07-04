// lowest common ancestor: means a node which contain both node (p & q) in its subtree. 
// Logic: travserse in left part and then right part, if node  find null then return null, if node matched with one of the (p & q) then return node or if left/right found not null then return it. 


// LeetCode :      https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
