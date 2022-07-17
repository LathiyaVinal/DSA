// "static void main" must be defined in a public class.
public class Main {
//    1

// / \

// 2 3

// / \ / \

// 4 5 6 7

// \

// 8
    
    
  public static class Node{
    int data;
    Node left, right;
    
    Node(int data){
      this.data = data;
    }
  }
    public static void main(String[] args) {
        
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
      root.left.left.right = new Node(8);      
      
      printRightViewOfTreeWithQueue(root);
    }
  
  
  public static void printRightViewOfTreeWithQueue(Node node){
    if(node == null){
      return;
    }
    
    Queue<Node> queue = new LinkedList<>();
    
    queue.add(node);
    
    while(!queue.isEmpty()){
      int size = queue.size();
      
      
      for(int i = 0 ; i < size ; i++){
        
        Node peeked = queue.remove();
        if(i == size-1){
          System.out.println(peeked.data);
        }
        
        if(peeked.left != null){
          queue.add(peeked.left);
        }
        if(peeked.right != null){queue.add(peeked.right);}
        
      }
      
    }
  }
  
  public static void printRightViewOfTree(Node node){
    if(node == null){
      return;
    }
    
    System.out.println(node.data);
    printRightViewOfTree(node.right);

  }
}
