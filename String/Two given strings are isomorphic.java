
import java.io.*;

class GFG {

    static final int CHAR = 26;

    // This function returns true if
    // str1 and str2 are isomorphic
    static boolean isoMorphic(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Length of both strings must be
        // same for one to one
        // correspondence
        if (n != m)
            return false;

        // For counting the previous appearances
        // of character in both the strings
        int[] countChars1 = new int[CHAR];
        int[] countChars2 = new int[CHAR];

        // Process all characters one by one
        for (int i = 0; i < n; i++) {

            countChars1[str1.charAt(i) - 'a']++;
            countChars2[str2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {

            if (countChars1[str1.charAt(i) - 'a'] != countChars2[str2.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        System.out.println(isoMorphic("aab", "xxy"));
        System.out.println(isoMorphic("aab", "xyz"));
    }
}

// This code is contributed by rohansharma1808
