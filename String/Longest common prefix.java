// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

class Solution {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = findPrefixBetweenTwoString(prefix, strs[i]);
        }
        return prefix;
    }

    public String findPrefixBetweenTwoString(String prefix, String str) {
        int i = 0, j = 0;

        while (i < prefix.length() && j < str.length()) {
            if (prefix.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return prefix.substring(0, i);
    }
}
