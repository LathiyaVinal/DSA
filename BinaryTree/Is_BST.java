class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validateNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validateNode(TreeNode node, long min, long max) {
        if (node.val <= min || node.val >= max) {
            return false;
        }

        if (node.left != null) {
            if (!validateNode(node.left, min, node.val)) return false;
        }

        if (node.right != null) {
            if (!validateNode(node.right, node.val, max)) return false;
        }

        return true;
    }
}
