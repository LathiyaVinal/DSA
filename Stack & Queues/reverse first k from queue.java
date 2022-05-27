// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      
      Queue<Integer> queue = new LinkedList<>();
      
      for(int i = 0 ; i < n ; i++){
        queue.add(sc.nextInt());
      }
      
      Stack<Integer> stack = new Stack<>();
      for(int i = 0  ;i < k ; i++){
        stack.push(queue.remove());
      }
      while(!stack.isEmpty()){
        queue.add(stack.pop());
      }
      
      for(int i = 0  ;i < (n-k) ; i++){
         queue.add(queue.remove());
      }
      
      for(int i = 0 ; i < n ; i++){
        System.out.print(queue.remove() + " ");
      }
    }
}
