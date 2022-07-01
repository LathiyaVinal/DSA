class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainList = new ArrayList<>();

        if (root == null) {
            return mainList;
        }
      
        boolean isLTR = true;
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        currentLevel.push(root);
        List<Integer> listCurrent = new ArrayList<>();

        while (!currentLevel.isEmpty()) {
            TreeNode top = currentLevel.pop();

            if (top != null) {
                listCurrent.add(top.val);

                if (isLTR) {
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                } else {
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                }
            }

            if (currentLevel.isEmpty()) {
                isLTR = !isLTR;

                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;

                mainList.add(listCurrent);
                listCurrent = new ArrayList<>();
            }
        }

        return mainList;
    }
}
