
class Solution {

    class Qobj {
        int level;
        TreeNode node;

        Qobj(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> outputlist = new ArrayList<>();

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Qobj> queue = new LinkedList<>();

        queue.add(new Qobj(0, root));

        int level;
        TreeNode node;

        while (!queue.isEmpty()) {
            Qobj peeked = queue.poll();

            level = peeked.level;
            node = peeked.node;

            if (map.containsKey(level)) {
                ArrayList<Integer> arrlist = map.get(level);
                arrlist.add(node.val);
                map.put(level, arrlist);
            } else {
                ArrayList<Integer> arrlist = new ArrayList<>();
                arrlist.add(node.val);
                map.put(level, arrlist);
            }

            if (node.left != null) {
                queue.add(new Qobj(level - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Qobj(level + 1, node.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            List<Integer> values = entry.getValue();

            List<Integer> subOutputlist = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                subOutputlist.add(values.get(i));
            }
            outputlist.add(subOutputlist);
        }
        return outputlist;
    }
}
