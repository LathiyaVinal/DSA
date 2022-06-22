/* Java Program to move last element to front in a given linked list */
class linkedlist_1 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void moveToFront() {
        if (head == null || head.next == null)
            return;

        Node secLast = null;
        Node last = head;
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        secLast.next = null;
        last.next = head;
        head = last;
    }

    public void push(int new_data) {
    
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        linkedlist_1 llist = new linkedlist_1();
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before moving last to front ");
        llist.printList();

        llist.moveToFront();

        System.out.println("Linked List after moving last to front ");
        llist.printList();
    }
}
