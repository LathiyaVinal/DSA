

import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 0; i < n - 1; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        head = segregate(head);
        printList(head);
        System.out.println();
    }

    public static void printList(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static class Node {

        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

//Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here

        int[] count = new int[3];
        Node current = head;
        while (current != null) {
            count[current.data]++;
            current = current.next;
        }

        current = head;

        int i = 0;
        while (current != null) {
            if (count[i] == 0) {
                i++;
            } else {
                current.data = i;
                current = current.next;
                count[i]--;
            }

        }

        return head;
    }

}
