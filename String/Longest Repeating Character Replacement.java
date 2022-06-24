// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.


class Solution {

    public int characterReplacement(String s, int k) {
        int[] cArr = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;

        for (int end = 0; end < s.length(); end++) {
            cArr[s.charAt(end) - 'A']++;

            maxCount = Math.max(maxCount, cArr[s.charAt(end) - 'A']);

            if (end - start + 1 - maxCount > k) {
                //if window size contains count of character which need to replace is more than k then window size will be decreassed .

                cArr[s.charAt(start) - 'A']--;
                start++;
            }

            maxSize = Math.max(maxSize, end - start + 1);
        }

        return maxSize;
    }
}
