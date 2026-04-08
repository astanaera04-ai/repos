package Learn_java;

import java.util.Scanner;

//Кіріс:
//        5
//        1 2 3 2 2
//        2
//
//Шығыс:
//        3
public class esep19 {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];

        for (int i =0; i < a; i++){
            arr[i] = sc.nextInt();
        }
        int s = sc.nextInt();
        int d = 0;
        for ( int i = 0; i <a; i++){
            if (arr[i] == s) d++;
        }
        System.out.println(d);

    }
}
