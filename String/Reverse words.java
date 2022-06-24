// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


class Solution {
    
    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");

        String[] strArr = s.split("\\s");

        int start = 0;
        int end = strArr.length - 1;

        while (start <= end) {
            String str = strArr[start];
            strArr[start] = strArr[end];
            strArr[end] = str;
            start++;
            end--;
        }

        String output = "";

        output = String.join(" ", strArr);

        return output;
      
    } 
}
