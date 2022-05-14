// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ;  i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        
        LinkedList linkedList = new LinkedList();
        
        for(int i = 0 ;  i < arr.length ; i++){
            linkedList.addLast(arr[i]);
        }
                
        linkedList.displayLinkedList();
    
    }
    
   
 
    
    public static class LinkedList{
        
        Node head;
        Node tail;
        int size;
        
         public class Node{
            int data;
            Node next;
        }
        
        
        public void displayLinkedList(){
            
            Node current = head;
            
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
          }
        public void addLast(int value){
            
            Node node = new Node();
            node.data = value;
            node.next = null;
            
            if(size == 0){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            
            size++;
        }
    }
    

}
