/*Node is defined as
class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
          //add code here.
          
        Node n1 = l1;
        Node n2 = l2;
        
        long mod = 1000000007;
        
        
        long ans1 = 0;
        long ans2 = 0;
        
        while(n1 != null){
            ans1 = ((ans1*10)+n1.data)%mod;
            n1 = n1.next;
        }
        while(n2 != null){
            ans2 = ((ans2*10)+n2.data)%mod;
            n2 = n2.next;
        }
        
        return (ans1*ans2)%mod;
        
   }
}
