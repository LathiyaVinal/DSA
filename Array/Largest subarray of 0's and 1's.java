//Time Complexity: O(n). 

class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        int sum = 0;
        int maxLength = 0;
        int endIndex = 0;
        
        for(int i = 0 ; i < N ; i++){
            
            sum = sum + arr[i];
            
            if(sum == 0){
                maxLength = i + 1;
                endIndex = i;
            }
            
            if(hash.containsKey(sum)){
                if(maxLength < (i - hash.get(sum))){
                    maxLength = i - hash.get(sum);
                    endIndex = i;
                }
            }else{
                hash.put(sum, i);
            }
        }
        
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == -1){
                arr[i] = 0;
            }
            
        }
        
        int startIndex = endIndex - maxLength + 1;
        
        return maxLength;
    }
}
