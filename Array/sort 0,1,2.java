class Solution {

    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length - 1;

        while (m <= h) {
            int X = nums[m];

            if (X == 0) {
                if (nums[l] != 0) {
                    int temp = nums[l];
                    nums[l] = nums[m];
                    nums[m] = temp;
                }
                l++;
                m++;
            } else if (X == 1) {
                m++;
            } else {
                if (nums[h] != 2) {
                    int temp = nums[m];
                    nums[m] = nums[h];
                    nums[h] = temp;
                }
                h--;
            }
        }
    }
}
