// Input : s = “abcdddddeff” 
// Output : 5 
// Substring is “ddddd”
// Input : s = aabceebeee 
// Output : 3 


import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int start = 0;
		int maxRepeatingCharLength = 0;
		int maxCount = Integer.MIN_VALUE;
		int[] charArr = new int[26];
		
		for(int end = 0 ; end <  str.length(); end++){
		    charArr[str.charAt(end) - 'A']++;
		    
		    maxCount = Math.max(maxCount, charArr[str.charAt(end) - 'A']);
		    
		    int windowSize = end-start+1;
		    if(windowSize > maxCount){
		        charArr[str.charAt(start) - 'A']--;
		        start++;
		    }
		    windowSize = end-start+1;
		    
		    maxRepeatingCharLength = Math.max(maxRepeatingCharLength, windowSize);
		}
		System.out.println(maxRepeatingCharLength);
	}
}
