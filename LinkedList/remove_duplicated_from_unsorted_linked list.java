import java.util.HashSet;

/* Java Program to move last element to front in a given linked list */
class Main {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node deleteDuplicateFromUnsortedList(){
        HashSet<Integer> set=new HashSet();  
        Node current = head;
        Node prev = head;
        while(current != null){
            if(set.contains(current.data)){
                while(current != null && set.contains(current.data)){
                    current = current.next;
                }
                // set.add(current.data);
                prev.next = current;
                // current = current.next;
            }else{
                set.add(current.data);
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void push(int new_data) {
    
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
       
        push(5);
        push(4);
        push(3);
        push(4);
        push(2);
        push(1);

        System.out.println("Linked List before removing ");
        printList();

        Node uniqList = deleteDuplicateFromUnsortedList();

        System.out.println("Linked List after removing ");
        printList();
    }
}
