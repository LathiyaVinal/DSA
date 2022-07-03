class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           
           ArrayList<Integer> outputList = new ArrayList<>();
           
           
           Queue<Node> queue = new ArrayDeque<>();
           Node sential = new Node(-1);
           
           while(root != null){
               queue.add(root);
               root = root.right;
           }
           
           queue.add(sential);
           
           while(queue.size() != 1){
               Node peeked = queue.poll();
               
               if(peeked.data != -1){
                    outputList.add(peeked.data);
               
                    Node node = peeked.left;
                    while(node != null){
                        queue.add(node);
                        node = node.right;
                    }
               }else{
                   queue.add(sential);
               }
           }
           
           return outputList;
      }
}
