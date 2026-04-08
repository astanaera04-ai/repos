package Learn_java;
//Кіріс:
//        5
//        2 3 2 4 3
//
//        Шығыс:
//        4
import java.util.Scanner;

public class esep20 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n;i++ ){
            int s = 0;
            for (int j = 0; j < n;j++ ){
                if (arr[i] == arr[j]) s++;
            }
            if (s == 1) System.out.println(arr[i]);
        }

    }
}
