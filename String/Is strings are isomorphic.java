// fill character array, character wise. with first loop
// second loop to compare count of charcater at same index from both string 
// EX:  str1 = aab , str2 = xxy
// at index 0 compare both characters value from character index. 
// for character "a" from str1, charArr1 at index-0 count is 2.
// for character "x" from str2, charArr2 at index-23 count is 2

///////////////////////////////////
// Input:  str1 = "aab", str2 = "xxy"
// Output: True

// Input:  str1 = "aab", str2 = "xyz"
// Output: False
//////////////////////////////////

import java.util.Scanner;

public class LeetCode_Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        boolean isIsoMorphic = isBothStringAreIsoMorphic(str1, str2);
        System.out.println(isIsoMorphic);
    }

    private static boolean isBothStringAreIsoMorphic(String str1, String str2) {
        boolean isIsoMorphic = true;

        char[] charArr1 = new char[26];
        char[] charArr2 = new char[26];

        if(str1.length() != str2.length()){
            return false;
        }

        for(int i = 0 ;  i < str1.length(); i++){
            charArr1[str1.charAt(i) - 'a']++;
            charArr2[str2.charAt(i) - 'a']++;
        }

        for(int i = 0 ;  i < str1.length(); i++){
            if(charArr1[str1.charAt(i) - 'a'] != charArr2[str2.charAt(i) - 'a']){
                return false;
            }
        }
       
        return isIsoMorphic;
    }
}
