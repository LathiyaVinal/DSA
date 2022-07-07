
class Solution {

    boolean check(Node root) {
        return checkIfLevelAreAtSameLevel(root);
    }

    boolean checkIfLevelAreAtSameLevel(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        int result = Integer.MAX_VALUE;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while (size > 0) {
                Node peeked = queue.poll();
                if (peeked.left != null) {
                    queue.add(peeked.left);

                    if (peeked.left.left == null && peeked.left.right == null) {
                        if (result == Integer.MAX_VALUE) {
                            result = level;
                        } else {
                            if (result != level) {
                                return false;
                            }
                        }
                    }
                }

                if (peeked.right != null) {
                    queue.add(peeked.right);

                    if (peeked.right.left == null && peeked.right.right == null) {
                        if (result == Integer.MAX_VALUE) {
                            result = level;
                        } else {
                            if (result != level) {
                                return false;
                            }
                        }
                    }
                }

                size--;
            }
        }

        return true;
    }
}
