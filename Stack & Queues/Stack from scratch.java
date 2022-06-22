// "static void main" must be defined in a public class.
public class MyStack {

    int top = -1;
    int n;
    int[] arr;

    MyStack(int n) {
        this.n = n;
        arr = new int[n];
    }

    void push(int data) {
        if (top < n - 1) {
            top++;
            arr[top] = data;
        } else {
            System.out.println("Stack overflow");
        }
    }

    void peek() {
        if (top == -1) {
            System.out.println("Stack empty");
        } else {
            int topval = arr[top];
            System.out.println(topval);
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
        } else {
            int topval = arr[top];
            top--;
            System.out.println(topval);
        }
    }

    public static void main(String[] args) {

        MyStack theStack = new MyStack(10);
        theStack.push(1);
        theStack.push(2);
        theStack.push(3);
        theStack.push(4);
        theStack.push(5);
        theStack.push(6);
        theStack.push(7);
        theStack.push(8);
        theStack.push(9);
        theStack.push(10);
        theStack.push(11);

        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();
        theStack.peek();

        theStack.pop();
        theStack.peek();
    }
}
