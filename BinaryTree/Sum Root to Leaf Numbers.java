
class Solution {

    public int sumNumbers(TreeNode root) {
        return sumPath(root, val);
    }

    int val = 0;

    public int sumPath(TreeNode node, int val) {
        if (node == null) return 0;

        val = (val * 10 + node.val);

        if (node.left == null && node.right == null) return val;

        return sumPath(node.left, val) + sumPath(node.right, val);
    }
}
