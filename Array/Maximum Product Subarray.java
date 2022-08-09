// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
  
  
  
class Solution {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int n = nums.length;

        int mi = nums[0];
        int ma = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = ma;
            ma = Math.max(nums[i], Math.max(nums[i] * ma, nums[i] * mi));
            mi = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * mi));
            ans = Math.max(ma, ans);
        }

        return ans;
    }
}
