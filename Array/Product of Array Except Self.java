// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] outArr = new int[nums.length];

        outArr[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            outArr[i] = outArr[i - 1] * nums[i - 1];
        }

        int temp = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            outArr[i] = outArr[i] * temp;
            temp = temp * nums[i];
        }

        return outArr;
    }
}
