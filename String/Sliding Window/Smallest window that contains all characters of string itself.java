//////////////////////
// Input: aabcbcdbca
// Output: dbca

// Input: aaab
// Output: ab
//////////////////////


// count all dictinct character first from string with first loop called : dictinctCount
// count character again with second loop and if in between count matches with dictinctCount then 
// from whatever start position remove element untill its frequency > 1.  
// this means window size will be decreased to remove duplicate character from first if found. 
// calculate new window length and update with global start index and minimum length; 
// second loop will go threw end of the length of string to get another minumum window length; 

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Pair pair = minimumWindowSizeWithAllChar(str);
        System.out.println("Minimum window length : " + pair.first);
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

    public static Pair minimumWindowSizeWithAllChar(String str) {

        int distinctCount = getCountOfDistinctChar(str);

        int start = 0;
        int count = 0;

        int[] visited = new int[256];
        int global_minWindow = Integer.MAX_VALUE;
        int global_startIndex = 0;

        for (int end = 0; end < str.length(); end++) {
            visited[str.charAt(end)]++;
            if (visited[str.charAt(end)] == 1) {
                count++;
            }

            if (count == distinctCount) {
                while (visited[str.charAt(start)] > 1) {
                    visited[str.charAt(start)]--;
                    start++;
                }

                int windowLength = end - start + 1;
                if (global_minWindow > windowLength) {
                    global_minWindow = windowLength;
                    global_startIndex = start;
                }
            }

        }
        return new Pair(global_minWindow, global_startIndex);
    }

    public static int getCountOfDistinctChar(String str) {
        int[] visited = new int[256];
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            visited[str.charAt(i)]++;

            if (visited[str.charAt(i)] == 1) {
                count++;

            }
        }
        return count;
    }
}
