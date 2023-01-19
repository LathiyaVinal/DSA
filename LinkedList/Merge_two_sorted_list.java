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

Time complexity: O(N + M )
    
class Solution {
    
    public class LinkedList{
        
        ListNode head;
        ListNode tail;
        int size = 0;
        
         void addLast(int val){
             
            ListNode listnode = new ListNode();
            listnode.val = val;
            listnode.next = null;
             
             if(size == 0){
                 head = tail = listnode;
             }else{
                 tail.next = listnode;
                 tail = listnode;
             }
             size++;
        }
    }
   
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        LinkedList output = new LinkedList();
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                output.addLast(list1.val);
                list1 = list1.next;
            }else{
                output.addLast(list2.val);
                list2 = list2.next;
            }
        }
        
        while(list1 != null){
             output.addLast(list1.val);
            list1 = list1.next;
        }
        
         while(list2 != null){
            output.addLast(list2.val);
             list2 = list2.next;
            
        }
        
        return output.head;
        
        
    }
}
