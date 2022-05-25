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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
