package Learn_java;

import java.util.Scanner;

//5
//        0 1 2 4 5
//
//Нәтиже:
//
//        3
public class esep21 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n ; i++) {
            if (i != arr[i]) System.out.println(i);
        }
    }
}
