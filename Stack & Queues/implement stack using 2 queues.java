class MyStack {
  
  Queue<Integer> q1;
  Queue<Integer> q2;
  int current_size;

    public MyStack() {
         q1 = new LinkedList<>();
       q2 = new LinkedList<>();
      current_size = 0;
      
    }
    
    public void push(int x) {
        q1.add(x);
      
      while(!q2.isEmpty()){
        q1.add(q2.remove());
      }
      
      Queue<Integer> q = q1;
      q1 = q2;
      q2 = q;
      
      current_size++;
    }
    
    public int pop() {
        if(current_size != 0){
          current_size--;
          return q2.remove();
        }
      return -1;
    }
    
    public int top() {
        if(current_size != 0){
          return q2.peek();
        }
      return -1;
    }
    
    public boolean empty() {
        if(current_size == 0){
          return true;
        }
      return false;
    }
}

 // Driver program to test twoStack class 
    public static void main(String args[]) 
    { 
        MyStack ts = new MyStack(); 
        ts.push(3); 
        ts.push(10); 
        ts.push(17); 
        ts.push(11); 
        ts.push(7); 
        System.out.println("Popped element from"
                           + " stack is " + ts.pop()); 
        ts.push(60); 
        System.out.println("Popped element from"
                           + " stack is " + ts.pop()); 
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
