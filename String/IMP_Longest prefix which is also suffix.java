/////////////////////////////////////
// Input : aabcdaabc
// Output : 4
// The string "aabc" is the longest
// prefix which is also suffix.

// Input : abcab
// Output : 2

// Input : aaaa
// Output : 2
//////////////////////////////////////

import java.util.Arrays;

public class getMaxLengthOfString {
    public static void main(String[] args) {
       
        String pattern = "ABABCABAB";

        int maxLength = getPatternArray(pattern);
        System.out.println(maxLength);
    }

    static int getPatternArray(String pattern) {
        int lengthOfPattern = pattern.length();

        int[] patternArray = new int[lengthOfPattern];
        patternArray[0] = 0;

        int i = 0, j = 1;

        while (j != lengthOfPattern) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                patternArray[j] = i + 1;
                i++;
                j++;
            } else {
                if(i >= 1){
                    i = patternArray[i - 1];
                 }else{
                   patternArray[j] = 0;
                    j++;
                 }
            }
        }

        int lastVal = patternArray[lengthOfPattern-1];
        if(lastVal > lengthOfPattern/2){
            return lengthOfPattern/2;
        }else{
            return lastVal;
        }
    }
}
