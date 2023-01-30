class Solution {
    
    
//      Input: nums = [100,4,200,1,3,2]
//      Output: 4
//      Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    
    //TC: O(nlogn)
    
    
    
    public int longestConsecutive(int[] nums) {
        
      int n = nums.length;
      if(n == 0){
        return n;
      }
      
      HashSet<Integer> hashmap = new HashSet<>();
      for(int i = 0 ; i < n ; i++){
        hashmap.add(nums[i]);
      }
      
      int ans = 1;
      int count = 1;
        
      //for every element we will find if its most previous element is exist in array or not,
        //         if not exist then we will check for most next element. 
      
      for(int i = 0 ; i < n ; i++){
        if(!hashmap.contains(nums[i] - 1)){
          int temp = nums[i];
          count =1;
          
          while(hashmap.contains(temp+1)){
            count++;
            temp = temp + 1;
          }
          
          ans = Math.max(ans, count);
        }
      }
      
      return ans;
    }
}
