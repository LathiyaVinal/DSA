/////////////////////////////////////
//  Input: s = ["H","a","n","n","a","h"]
//  Output: ["h","a","n","n","a","H"]
/////////////////////////////////////


class Solution {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while (start < end) {
          char first = s[start];
          s[start] = s[end];
          s[end] = first;
          start++;
          end--;
        } 
    }
}




//////////// Better solution, takes lesser time compare to above ////////////////
class Solution {

    public void reverseString(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j--;
        }

        return;
    }
}
