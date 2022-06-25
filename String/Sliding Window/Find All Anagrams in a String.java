// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]


class Solution {

    public List<Integer> findAnagrams(String str, String p) {
        List<Integer> list = new ArrayList<>();
        if (str == null || str.length() == 0 || p == null || p.length() == 0) {
            return list;
        }

        if (p.length() > str.length()) {
            return list;
        }
        int[] pattern_hash = new int[26];
        int[] string_hash = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pattern_hash[p.charAt(i) - 'a']++;
            string_hash[str.charAt(i) - 'a']++;
        }
        int start = 0;

        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 1, 2, 3 };

        if (Arrays.equals(pattern_hash, string_hash)) {

            list.add(start);
        }

        for (int i = p.length(); i < str.length(); i++) {
            string_hash[str.charAt(i) - 'a']++;
            string_hash[str.charAt(start) - 'a']--;
            start++;

            if (Arrays.equals(pattern_hash, string_hash)) {
                list.add(start);
            }
        }
        return list;
    }
}
