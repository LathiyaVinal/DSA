 //TC :  O(log n).


public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int ans = countOnesFromSortedBinaryArr(arr, 0, n-1);
        
        System.out.print(ans);
    }
    
    public static int countOnesFromSortedBinaryArr(int[] arr, int low, int high){
        
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(arr[mid] == 0){
                if(mid == low || arr[mid-1] == 1){
                    return mid;
                }else{
                    high = mid-1;       
                }
            }else{
                if(mid == high || arr[mid+1] == 0){
                    return mid+1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return 0;
    }
