// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
        
        int arrSize = sc.nextInt();
        
        int[] arr = new int[arrSize];
        
        for(int i = 0 ; i < arrSize; i++){
            arr[i] = sc.nextInt();
        }
        
        printAllSubArray(arr, 0 , 0);
    }
    
    public static void printAllSubArray(int[] nums, int start, int end){
       
        if(end >= nums.length){
            return;
        }
       while(start <= end){
           for(int i = start; i <= end; i++){
               System.out.print(nums[i] + " ");
           }
           
           System.out.println();
           start++;
       }
        
        if(start > end){
            start = 0;
            end = end+1;
            
            printAllSubArray(nums, start, end);
            
            
        }
        
        
        
    }
}
