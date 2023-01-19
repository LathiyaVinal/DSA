// Time complexity: O(N)

class Solution {
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        // write your code here
        left = head;
        return checkIfPalindrome(head);
    }

    public boolean checkIfPalindrome(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean out = checkIfPalindrome(right.next);

        if (out == false) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            left = left.next;
            return true;
        }
    }
}



//////////// another method with stack 

class Solution {
    ListNode left;

    public boolean isPalindrome(ListNode head) {
      
      Stack<ListNode> listnode = new Stack<>();
      
      ListNode current = head;
      
      while(current != null){
        listnode.push(current);
        current = current.next;
      }
      
      while(!listnode.isEmpty()){
        
        ListNode top = listnode.pop();
                
        if(head.val != top.val){
          return false;
        
        }else{
          head = head.next;
        }
      }
      return true;
    }
}
