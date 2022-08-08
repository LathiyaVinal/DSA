// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
       
      // X: ABCBDAB
      // Y: BDCABA
      //LCS are BDAB, BCAB, and BCBA


  
      Scanner sc = new Scanner(System.in);
      String str1 = sc.next();
      String str2 = sc.next();
      

      char[] arr1 = str1.toCharArray();
      char[] arr2 = str2.toCharArray();
      
      int len1 = arr1.length;
      int len2 = arr2.length;
      
      int output = findLongestCommenSequance(arr1, arr2, len1, len2);
      
      System.out.println(output);
    }
  
  public static int findLongestCommenSequance(char[] str1,  char[] str2, int length1, int length2){
    
    if(length1 == 0 || length2 == 0){
      return 0;
    }
    
    if(str1[length1-1] == str2[length2-1]){
     return 1 + findLongestCommenSequance(str1, str2, length1-1, length2-1);
    }else{
      return Math.max(findLongestCommenSequance(str1, str2, length1, length2-1),
               findLongestCommenSequance(str1, str2, length1-1, length2));
    }
  }
}
