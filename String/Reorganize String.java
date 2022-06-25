// get charcater which one is repeating maximum time and get its count
// put all thsese character at every even index
// for remaining character in string at remaining even index first if it available,
// if not event place are full then start filling at odd index. 

// Example 1:

// Input: s = "aab"
// Output: "aba"
// Example 2:

// Input: s = "aaab"
// Output: ""

class Solution {

    public String reorganizeString(String str) {
        if (str.length() == 0) {
            return "";
        }

        int[] charArr = new int[26];

        int maxCount = Integer.MIN_VALUE;
        char maxRepeatedChar = 0;
        for (int i = 0; i < str.length(); i++) {
            charArr[str.charAt(i) - 'a']++;

            if (charArr[str.charAt(i) - 'a'] > maxCount) {
                maxCount = charArr[str.charAt(i) - 'a'];
                maxRepeatedChar = str.charAt(i);
            }
        }

        if (maxCount > (str.length() + 1) / 2) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            output.append(" ");
        }

        int index = 0;

        while (maxCount != 0) {
            output.setCharAt(index, maxRepeatedChar);
            maxCount--;
            index = index + 2;
        }
        charArr[maxRepeatedChar - 'a'] = 0;

        for (int i = 0; i < charArr.length; i++) {
            while (charArr[i] > 0) {
                if (index >= str.length()) {
                    index = 1;
                }
                output.setCharAt(index, (char) ((int) 'a' + i));
                index = index + 2;
                charArr[i]--;
            }
        }
        return output.toString();
    }
}
