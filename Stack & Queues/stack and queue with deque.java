// "static void main" must be defined in a public class.
public class Main {
  
   public static class Deque {

        int data;
        Deque head;
        Deque tail;
        Deque prev;
        Deque next;
        int currentSize = 0;

        boolean isEmpty() {
            if (currentSize == 0) {
                return true;
            }
            return false;
        }

        int removeFromFirst() {

            if (currentSize == 0) {
                return -1;
            } else {
                Deque temp = head;
                if (head.next == null) {
                    head.prev = null;
                    head = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }

                currentSize--;
                return temp.data;
            }
        }

        void display() {

            // If list is not empty
            if (!isEmpty()) {
                Deque temp = head;

                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }

                return;
            }
            System.out.print("List is Empty");
            // return 0;
        }

        int removeFromLast() {
            if (currentSize == 0) {
                return -1;
            } else {
                currentSize--;

                Deque temp = tail;
                if (tail.prev == null) {
                    tail.next = null;
                    tail = null;
                } else {

                    tail = tail.prev;
                    tail.next = null;
                }
                return temp.data;
            }
        }

        void addAtLast(int data) {
            Deque de = new Deque();
            de.data = data;
            de.next = null;
            if (currentSize == 0) {
                de.prev = null;
                de.next = null;
                head = de;
                tail = de;
            } else {

                tail.next = de;
                de.prev = tail;
                tail = de;
            }
            currentSize++;
        }

    }

    public static void main(String[] args) {

        Deque stack = new Deque();
        stack.addAtLast(3);
        stack.addAtLast(4);
        stack.addAtLast(5);
        stack.addAtLast(6);
        stack.display();
        System.out.println("Stack empty: " + stack.isEmpty());
        System.out.println("Stack pop: " + stack.removeFromLast());
        System.out.println("Stack pop: " + stack.removeFromLast());
        System.out.println("Stack pop: " + stack.removeFromLast());
        System.out.println("Stack pop: " + stack.removeFromLast());
        System.out.println("Stack pop: " + stack.removeFromLast());
        System.out.println("Stack empty: " + stack.isEmpty());

        Deque queue = new Deque();
        queue.addAtLast(3);
        queue.addAtLast(4);
        queue.addAtLast(5);
        queue.addAtLast(6);

        System.out.println("Queue empty: " + queue.isEmpty());
        System.out.println("Queue pop: " + queue.removeFromFirst());
        System.out.println("Queue pop: " + queue.removeFromFirst());
        System.out.println("Queue pop: " + queue.removeFromFirst());
        System.out.println("Queue pop: " + queue.removeFromFirst());
        System.out.println("Queue pop: " + queue.removeFromFirst());
        System.out.println("Queue empty: " + queue.isEmpty());
    }
}
