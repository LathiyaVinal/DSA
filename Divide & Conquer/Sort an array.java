// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]



class Solution {

    public int[] sortArray(int[] nums) {

        mergeSort(nums);

        return nums;
    }

    public void mergeSort(int[] nums) {

        int n = nums.length;

        if (n < 2) {
            return;

        }

        int mid = (int) (n) / 2;

        int[] arrLeft = new int[mid];
        int[] arrRight = new int[n - mid];

        int i1 = 0;
        int j1 = 0;

        for (int i = 0; i <= mid - 1; i++) {
            arrLeft[i1] = nums[i];
            i1++;
        }

        for (int j = mid; j <= n - 1; j++) {
            arrRight[j1] = nums[j];
            j1++;
        }

        mergeSort(arrLeft);
        mergeSort(arrRight);
        mergeSort(arrLeft, arrRight, nums);
    }

    public void mergeSort(int[] arrLeft, int[] arrRight, int[] nums) {
        int nL = arrLeft.length;
        int nR = arrRight.length;

        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (arrLeft[i] < arrRight[j]) {
                nums[k] = arrLeft[i];
                i++;
                k++;
            } else {
                nums[k] = arrRight[j];
                j++;
                k++;
            }
        }

        while (i < nL) {
            nums[k] = arrLeft[i];
            i++;
            k++;

        }

        while (j < nR) {
            nums[k] = arrRight[j];
            j++;
            k++;
        }

    }
}
