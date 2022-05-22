class Solution {
    public boolean isAnagram(String s, String t) {
      
      if(s.length() != t.length()){
        return false;
      }      
      
      int[] s_arr = new int[26];
      int[] t_arr = new int[26];
      
      for(int i = 0 ; i < s.length(); i++){
        
        int s_index = s.charAt(i)-'a';
        int t_index = t.charAt(i)-'a';
        
        s_arr[s_index]++; 
        t_arr[t_index]++; 
        
        
      }
      
      for(int i = 0 ; i < 26; i++){
        if(s_arr[i] != t_arr[i]){
          return false;
        }
      }
      
        return true;
    }
}
