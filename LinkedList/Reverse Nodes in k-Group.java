//////////////////////////////////////
// Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
// Output:  3->2->1->6->5->4->8->7->NULL. 
//
// Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
// Output:  5->4->3->2->1->8->7->6->NULL.
//////////////////////////////////////


class Solution {

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stackList = new Stack<>();

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
           int c = 0;
            while (current != null && c < k) {
                stackList.push(current);
                current = current.next;
                c++;
            }

            while (!stackList.isEmpty()) {
             
                if (prev == null) {
                    prev = stackList.pop();
                    head = prev;
                } else {
                    prev.next = stackList.pop();
                    prev = prev.next;
                }
            }
            prev.next = null;
        }
        return head;
    }
}






/////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////
// Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
// Output:  3->2->1->6->5->4->7->8->NULL. 
//
// Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
// Output:  5->4->3->2->1->6->7->8->NULL.
//////////////////////////////////////


class Solution {

    static int lengthOfLinkedList(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = lengthOfLinkedList(head);

        Stack<ListNode> stackList = new Stack<>();

        ListNode prev = null;
        ListNode current = head;

        while (current != null && length >= k) {
            int c = 0;
            while (current != null && c < k) {
                stackList.push(current);
                current = current.next;
                c++;
                length--;
            }

            while (!stackList.isEmpty()) {
                if (prev == null) {
                    prev = stackList.pop();
                    head = prev;
                } else {
                    prev.next = stackList.pop();
                    prev = prev.next;
                }
            }
            prev.next = null;
        }
        while (current != null && prev != null) {
            prev.next = current;
            current = current.next;
            prev = prev.next;
        }
        if (prev != null) {
            prev.next = null;
        }

        return head;
    }
}
