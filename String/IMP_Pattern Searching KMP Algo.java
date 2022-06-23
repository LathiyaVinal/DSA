///////////////////////////
//  OP : Found pattern at index 10 
//////////////////////////

// DESCRIPTION : How to craete pattern array : 
// Create array with length of pattern and its first item will be 0 always 
// i = 0; 
// j = 1; -> here j is index at which we will fill value in array
// if character at i & j position are equal then value to be filled in array is (i+1) 
// take value at (i-1) and put i to that 

import java.util.Arrays;

public class SearchPattern {
    public static void main(String[] args) {
        String MainString = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] patternArray = getPatternArray(pattern);
        System.out.println("Pattern Array : " + Arrays.toString(patternArray));

        SearchAllPatternIndexFromString(pattern, MainString, patternArray);
    }

    static void SearchAllPatternIndexFromString(String pat, String txt, int[] lps)
    {
        int M = pat.length();
        int N = txt.length();
 
        int j = 0; // index for pat[]
 
        int i = 0; // index for txt[]


        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                                + "at index " + (i - j));
                j = lps[j - 1];
            }
 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    static int[] getPatternArray(String pattern) {
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
        return patternArray;
    }
}
