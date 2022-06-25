
///////////// LOGIC /////////////////
// take eat, then sort it with, 
// then set sorted string as key of hashmap and put unsorted string to value 
///////////// LOGIC /////////////////

//////////////////////////////
// input
// ["eat","tea","tan","ate","nat","bat"]
// Output
// [["eat","tea","ate"],["bat"],["tan","nat"]]
//////////////////////////////


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LeetCode_Practice {

    public static void main(String[] args) {
       
        String[] str = {"cat", "dog", "tac", "god", "act"};
        List<List<String>> op = groupAnagrams(str);
        System.out.println(op);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> opList = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(int i = 0 ; i < strs.length; i++){
            String str = strs[i];
            char []arr = str.toCharArray();
            Arrays.sort(arr);
            if(hashMap.containsKey(String.valueOf(arr))){
                List<String> val = hashMap.get(String.valueOf(arr));
                val.add(str);
                hashMap.put(String.valueOf(arr), val);
            }else{
                List<String> val = new ArrayList<>();
                val.add(str);
                hashMap.put(String.valueOf(arr), val);
            }
        }
        for (HashMap.Entry<String, List<String>> list : hashMap.entrySet()) {
            opList.add(list.getValue());
        }
        return opList;
    }
}
