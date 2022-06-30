// Given an array of integers nums and an integer k, 
//return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2



class Solution {
    public static int subarraySum(int[] nums, int k) {

        int n = nums.length;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        int ans = 0;
        int sum = 0;
        
        hashmap.put(0,1);
        
       for(int i = 0 ; i <n ; i++){
           sum = sum + nums[i];
           
           if(hashmap.containsKey(sum-k)){
               ans = ans + hashmap.get(sum-k);
           }
           
           if(hashmap.containsKey(sum)){
               hashmap.put(sum, hashmap.get(sum) + 1);
           }else{
               hashmap.put(sum, 1);
           }
       }
        
        return ans;
    }
}
