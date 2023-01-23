// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.
// Example 2:

// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
// Example 3:

// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
  

//TC:  O(log n).
  
  class Solution {

    public int findMin(int[] nums) {
        return findMinimum(0, nums.length - 1, nums);
    }

    public int findMinimum(int start, int end, int[] nums) {
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }

        int mid = (start + end) / 2;

        if (nums[mid] > nums[end]) {
            return findMinimum(mid, end, nums);
        } else {
            return findMinimum(start, mid, nums);
        }
    }
}
