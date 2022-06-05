class Solution {

    //Function to remove a loop in the linked list.
    public static void removeLoop(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        Node slow = node.next;
        Node fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            slow = node;

            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
