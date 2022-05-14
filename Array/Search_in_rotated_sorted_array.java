
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinal Lathiya
 */
public class Search_in_rotated_sorted_array {
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0 ;  i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        
            
        int output = searchInRotatedSortedArray(arr, 0, n-1, k);
        
        System.out.println("index :" + output);
    }
            
    
    public static int searchInRotatedSortedArray(int[] nums, 
                                                  int start, 
                                                  int end, 
                                                  int target){
        
        if(start <= end){
            int mid = (start + end)/2;
            
            if(nums[mid] == target){
                return mid;
            }else {
                if(nums[mid] <= nums[end]){
                    
                    if(target > nums[mid] && target <= nums[end]){
                         return searchInRotatedSortedArray(nums, mid+1, end, target);
                    }else{
                        return searchInRotatedSortedArray(nums, start, mid-1, target);
                    }
                    
                }else{
                    if(target >= nums[start] && target < nums[mid]){
                        return searchInRotatedSortedArray(nums, start, mid-1, target);
                    }else{
                        return searchInRotatedSortedArray(nums, mid+1, end, target);
                    }
                }
            }
        }
        
        return -1;
    }
}
