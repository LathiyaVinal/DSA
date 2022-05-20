class Solution {
    public boolean isPalindrome(String s) {
        
      s = s.replaceAll("[^A-Za-z0-9]", "");
      
      s = s.toLowerCase();
      
      s.replace(" ", "");
      
      int start = 0;
      int end = s.length() - 1;
      
     while(start < end){
       if(s.charAt(start) != s.charAt(end)){
         return false;
       }else{
         start++;
         end--;
       }
     }
      
    return true;
      
      
    }
}
