//////////////////////
// Input: ABCDEFR
// Output: Maximum window length : 7 , Start Index : 0

// Input: ABDEFGABEF
// Output: Maximum window length : 6 , Start Index : 1

// Input: BBBB
// Output: Maximum window length : 1, Start Index : 1
//////////////////////

// add frequency of each character, if at any position frequecy found > 1, 
// then remove character from start untill we get frequency of same character to 1. 
// distinctChar variable is used incase if whole input string contains uniq character then 
// output string length will be equal to length of input string length. 

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Pair pair = longestUniqSubstring(str);
        System.out.println("Maximum window length : " + pair.first);
        System.out.println("Start Index : " + pair.second);
    }

    public static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair longestUniqSubstring(String str) {
        char[] charArr = new char[256];
        int global_maxWindowSize = 0;
        int global_startIndex = 0;
        int start = 0;
        int distinctChar = 0;

        for (int end = 0; end < str.length(); end++) {
            charArr[str.charAt(end)]++;

            if (charArr[str.charAt(end)] > 1) {
                while (charArr[str.charAt(end)] > 1) {
                    charArr[str.charAt(start)]--;
                    start++;
                }

                int windowSize = end - start + 1;

                if (windowSize > global_maxWindowSize) {
                    global_maxWindowSize = windowSize;
                    global_startIndex = start;
                }
                
            }else{
                distinctChar++;
            }
        }

        if(distinctChar == str.length()){
            return new Pair(str.length(), 0);
        }
        return new Pair(global_maxWindowSize, global_startIndex);
    }
}
