// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      Queue<Integer> q = new LinkedList<>();
      
      for(int i = 0 ; i < n ;i++){
        q.add(sc.nextInt());
      }
      
      Stack<Integer> st = new Stack<>();
      
      while(!q.isEmpty()){
        st.push(q.remove());
      }
      
      while(!st.isEmpty()){
        q.add(st.pop());
      }
      
       while (!q.isEmpty()) {
            System.out.print(q.peek() + ", ");
            q.remove();
        }
    }
}
