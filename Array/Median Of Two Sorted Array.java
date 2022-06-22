class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int n = nums1.length;
        int m = nums2.length;
        
        int te = n + m;
        
        int low = 0;
        int high = n;
        
        int al = (low+high)/2;
        
        while(low <= high){
            
            int bl = (te+1)/2 - al;
            
            int aLeft = (al == n) ? Integer.MAX_VALUE : nums1[al];
            int aLeftM1 = (al == 0) ? Integer.MIN_VALUE : nums1[al-1];
            int bLeft = (bl == m) ? Integer.MAX_VALUE : nums2[bl];
            int bLeftM1 = (bl == 0) ? Integer.MIN_VALUE : nums2[bl-1];
            
            
            if(aLeftM1 <= bLeft && bLeftM1 <= aLeft){
                
                int alm = Math.max(aLeftM1, bLeftM1);
                int blm = Math.min(aLeft, bLeft);
                
                double median;
                if(te % 2 == 0){
                    median = (alm + blm)/2.0;
                }else{
                    median = Math.max(aLeftM1, bLeftM1);
                }
                return median;
                
            }else if(aLeftM1 > bLeft){
                al = al - 1;
            }else if(bLeftM1 > aLeft){
                al = al + 1;
            }
            
        }
        
        return 0;
        
    }
}
