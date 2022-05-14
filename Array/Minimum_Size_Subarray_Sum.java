class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        
        
        int l = 0 , r = 0;
        int n = arr.length;
        
        int sum= 0;
        
        int windowLength = Integer.MAX_VALUE;
        
        
        for(r = 0 ; r < n ; r++){
            
            sum = sum + arr[r];
            
            if(sum >= target){
                while(sum >= target && (sum - arr[l]) >= target){
                    sum = sum - arr[l];
                    l++;
                }
            }
            
            if(sum >= target){
                 windowLength = Math.min(windowLength, (r-l+1));
            }
            
        }
        
      
        
        return windowLength == Integer.MAX_VALUE ? 0 : windowLength;
        
    }
}
