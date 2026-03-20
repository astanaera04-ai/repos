package alg_ass1;
//Task 4. Factorial
//        Write a recursive function that calculates n! (factorial).

import java.util.Scanner;

public class Task5 {
    public static int fib(int a,int b, int c, int d, int s){
        d = c + b;
        b = c;
        c = d;
        if (a == s) return d;
        s++;
        return fib(a, b , c, d,  s );
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = 0;
        int c = 1;

        int d = 0;
        int s = 2;

        if (a == 1) System.out.println(0);
        else if (a==2) System.out.println(1);
        else System.out.println(fib(a ,b ,c ,d ,s ));

    }
}
//package alg_ass1;
//
//import java.util.Scanner;
//
//public class Task5 {
//
//    public static int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fib(n - 1) + fib(n - 2);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(fib(n));
//    }
//}
