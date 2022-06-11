class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> main_list = new ArrayList<>();

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);

        while (!qu.isEmpty()) {
            int size = qu.size();

            List<Integer> list1 = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode top = qu.poll();
                list1.add(top.val);
                if (top.left != null) {
                    qu.offer(top.left);
                }
                if (top.right != null) {
                    qu.offer(top.right);
                }
            }
          
          main_list.add(list1);
        }
      return main_list;
    }
}
