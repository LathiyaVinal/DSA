// create chararray for patten 
// with second loop, add fraquency of each character of string one by one,
// logic for increament count is : 
// EX: string = "abcd"
// pattern = "badc", 
// for char "a",  both char array will contain frequency val : 1  then increase counter.
// when counter will increatemented ? 
// string = "aaaabcdd"
// pattern = "baddc";
// at 0th index, at 4th index, at 5th index, at 6th index, at 7th index. 
// because if frequency of same char exceed than pattern's char frequency,
// there is no need to increament count because we want to compare count with patterns length. 

// when counter equal to length of patern then try to minimize window size if possible. 
// window size will be minimize untill window does contains frequency greater than pattern's for same character. 

// Input: string = “this is a test string”, pattern = “tist” 
// Output: Minimum window is “t stri” 

class Solution {
    public String minWindow(String str, String pat) {
        if (str.length() < pat.length()) {
            return "";
        }
        char[] patternChar = new char[256];

        for (int i = 0; i < pat.length(); i++) {
            patternChar[pat.charAt(i)]++;
        }

        char[] strChar = new char[256];
        int count = 0;
        int start = 0;

        int global_windowLength = Integer.MAX_VALUE;
        int global_startIndex = 0;

        for (int end = 0; end < str.length(); end++) {
            strChar[str.charAt(end)]++;

            if (strChar[str.charAt(end)] <= patternChar[str.charAt(end)]) {
                count++;
            }

            if (count == pat.length()) {
                while (strChar[str.charAt(start)] > patternChar[str.charAt(start)]) {
                    strChar[str.charAt(start)]--;
                    start++;
                }

                int windowLength = end - start + 1;

                if (global_windowLength > windowLength) {
                    global_windowLength = windowLength;
                    global_startIndex = start;
                }
            }
        }

        if (global_windowLength == 0) {
            return "";
        } else {

            if (global_windowLength == Integer.MAX_VALUE) {
                return "";
            }
            str = str.substring(global_startIndex, global_startIndex + global_windowLength);

            return str;
        }
    }
}
