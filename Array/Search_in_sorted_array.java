
import java.util.Scanner;

public class Search_in_sorted_array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int arrSize = sc.nextInt();

        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();

        }

        findElement(arr, 0, arr.length - 1, X);

    }

    public static void findElement(int[] arr, int first, int last, int X) {
        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] > X) {
                first = mid + 1;
            } else if (arr[mid] == X) {
                System.out.println(mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }

        if (first > last) {
            System.out.println(-1);
        }
    }
}
