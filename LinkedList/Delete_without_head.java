/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//TC: O(1)


class Solution {
    public void deleteNode(ListNode node) {
        
      ListNode next = node.next;
      node.val = next.val;
      node.next = next.next;
      next = null;
    }
}
