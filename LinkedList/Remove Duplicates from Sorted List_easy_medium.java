/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    
    // easy level Input : 1 2 2 3 3 4 5 5 6, Output : 1 2 3 4 5 6
    public ListNode deleteDuplicates(ListNode head) {
        
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null){
            if(slow.val == fast.val){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        return head;
        
        
    }
}




// medium level Input : 1 2 2 3 3 4 5 5 6, Output : 1 4 6

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  
  public ListNode create(int data){
    //this function needed in case of input : 1 1 1 2 3 4 5 6
        ListNode tmp = new ListNode();
        tmp.val = data;
        tmp.next = null;
        return tmp;
    }
  
    public ListNode deleteDuplicates(ListNode head) {
        
      ListNode prev = create(-1);
      ListNode dummy = prev;
      ListNode current = head;
      prev.next = head;
            
      while(current != null && current.next != null){
                
        if(current.val == current.next.val){
            while(current != null && current.next != null && current.val == current.next.val){
              current = current.next;
            }
          prev.next = current.next;
          current = current.next;
        }else{
          prev = current;
          current = current.next;
        }
      }
      return dummy.next;
    }
}
