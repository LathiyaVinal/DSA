class Solution {

    public TreeNode bstToGst(TreeNode root) {
        findGreater(root);

        return root;
    }

    int sum = 0;

    public void findGreater(TreeNode root) {
        if (root == null) {
            return;
        }

        findGreater(root.right);

        int nodeData = root.val;
        sum = sum + nodeData;
        root.val = sum;

        findGreater(root.left);
    }
}
