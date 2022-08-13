// Example : 

// Input : arr[] = {15, 4, 15}
// Output : 0
// Array is already a palindrome. So we
// do not need any merge operation.

// Input : arr[] = {1, 4, 5, 1}
// Output : 1
// We can make given array palindrome with
// minimum one merging (merging 4 and 5 to
// make 9)

// Input : arr[] = {11, 14, 15, 99}
// Output : 3
// We need to merge all elements to make
// a palindrome.
 
class GFG
{
    // Returns minimum number of count operations
    // required to make arr[] palindrome
    static int findMinOps(int[] arr, int n)
    {
        int ans = 0; // Initialize result
 
        // Start from two corners
        for (int i=0,j=n-1; i<=j;)
        {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j])
            {
                i++;
                j--;
            }
 
            // If left element is greater, then
            // we merge right two elements
            else if (arr[i] > arr[j])
            {
                // need to merge from tail.
                j--;
                arr[j] += arr[j+1] ;
                ans++;
            }
 
            // Else we merge left two elements
            else
            {
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }
 
        return ans;
    }
 
    // Driver method to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 4, 5, 9, 1} ;
        System.out.println("Count of minimum operations is "+
                                findMinOps(arr, arr.length));
     
    }
}
