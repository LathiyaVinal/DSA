// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.




class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
    
        int start = 0;
        int end = 0;

        int maxLength = 0;
      

        Set<Character> hashSet = new HashSet<Character>();

        while (start < length && end < length) {
            if (hashSet.contains(s.charAt(end))) {
                hashSet.remove(s.charAt(start));
                start++;
            } else {
                hashSet.add(s.charAt(end));
                end++;

                maxLength = Math.max(maxLength, (end - start));
            }
        }
        return maxLength;
    }
}

