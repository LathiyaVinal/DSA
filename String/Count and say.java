// starting count will be 1. 
// if character at j index and j-1 are same then we will increament counter, 
// and when we found non matching character,
// then we will print simply counter and character at j-1 index. 
// $ is added at the end of the string to get count of last character itself. 
// output will be stord in string "S", and it will be updated by new values,
// thats why it is set to empty before processing. 


// 1,11,21,1211,111221,312211,...
// 1 ---> there is one 1
// 11 ---> There is two 1
// 21 ---> There is one 2 , one 1
// 1211 ---> There is one 1, one 2, two 1 ans so on.....


import java.util.Scanner;

public class LeetCode_Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = getCountAndSayValueAtIndex(n);
        System.out.println(s);
    }

    private static String getCountAndSayValueAtIndex(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String s = "11";
        int count = 1;

        for (int i = 3; i <= n; i++) {
            count = 1;

            String temp = s + "$";
            s = "";

            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) == temp.charAt(j - 1)) {
                    count++;
                } else {
                    s = s + String.valueOf(count) + temp.charAt(j - 1);
                    count = 1;
                }
            }
        }
        return s;

    }
}
