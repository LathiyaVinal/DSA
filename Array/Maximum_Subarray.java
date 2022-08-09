// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
    
// This program will use kadane's algorithm. 
// if currentSum if negative, then start from current element, else append current element in current sum.
// and check for maximum of currentsum and overallSum.
    
class Solution {
    public int maxSubArray(int[] nums) {
        
        int cSum = nums[0];
        int oSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (cSum < 0) {
                cSum = nums[i];
            } else {
                cSum = cSum + nums[i];
            }

            if (cSum > oSum) {
                oSum = cSum;
            }
        }
        return oSum;
    }
}
