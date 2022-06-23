///////////////////////////
//  OP : Found pattern at index 10 
//////////////////////////

import java.util.Arrays;

public class linkedlist_1 {
    public static void main(String[] args) {
        String MainString = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] patternArray = getPatternArray(pattern);
        System.out.println("Pattern Array : " + Arrays.toString(patternArray));

        KMPSearch(pattern, MainString, patternArray);
    }

    static void KMPSearch(String pat, String txt, int[] lps)
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

    static boolean isMainStringContainsPattern(String mainString, String pattern, int[] patternArray){
        int i = 0, j = 0;
        boolean isContain = false;

        while(i < mainString.length() && j < pattern.length()){
            if(mainString.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                while (pattern.charAt(i) != pattern.charAt(j)) {

                    if (i >= 1) {
                        i = patternArray[i - 1];
                    } else {
                        break;
                    }
                }
            }
        }

        return isContain;
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
                while (pattern.charAt(i) != pattern.charAt(j)) {

                    if (i >= 1) {
                        i = patternArray[i - 1];
                    } else {
                        break;
                    }
                }
                if (pattern.charAt(i) != pattern.charAt(j)) {
                    patternArray[j] = 0;
                    j++;
                } else {
                    patternArray[j] = i + 1;
                    i++;
                    j++;
                }
            }
        }
        return patternArray;
    }
}
