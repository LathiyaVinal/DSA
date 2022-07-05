public class Main {
  
  public static class Node{
    int data;
    Node left, right;
    Node(int data){
      this.data = data;
    }
  }
  
  public static Node root;
    public static void main(String[] args) {
        
      int[] arr = {1,2,3,4,5,6,7};
      createTree(arr);
      inOrderTraversal(root);
    }
  
  public static void inOrderTraversal(Node node){
    if(node == null){
      return;
    }
    inOrderTraversal(node.left);
    System.out.print(node.data + " ");
    inOrderTraversal(node.right);
    
  }
  public static void createTree(int[] arr){
    Queue<Node> queue = new LinkedList<>();
    
     root = new Node(arr[0]);
      queue.add(root);
    
      for(int i = 1; i < arr.length; i++){
         Node root_child = new Node(arr[i]);
        
          Node peeked = queue.peek();
        
          if(peeked.left == null){
            peeked.left = root_child;
            queue.add(root_child);
          }else if(peeked.right == null){
            peeked.right = root_child;
            queue.add(root_child);
            queue.poll();
          }
      }
  }
}
