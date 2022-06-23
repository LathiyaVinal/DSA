// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1


class Solution {

    public int firstUniqChar(String s) {
        int[] flag = new int[26];

        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (flag[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
