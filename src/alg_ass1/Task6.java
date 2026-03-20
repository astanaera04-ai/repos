package alg_ass1;
//Task 6. Power Function
//        You are given numbers a and n. Write a recursive function that
//        returns:
import java.util.Scanner;

public class Task6 {

    public static long power(int a, int n) {
        if (n == 0) return 1;           // базалық жағдай: a^0 = 1
        return a * power(a, n - 1);    // рекурсия: a * a^(n-1)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(power(a, n));
    }
}

//package alg_ass1;
//
//import java.util.Scanner;
//
//public class Task6 {
//
//    public static int pow( int a, int b,int d, int c){
//        a *=d;
//        if ( c == b) return a;
//        c++;
//
//        return pow( a, b, d, c);
//    }
//
//    static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int d = a;
//
//        if (b == 0) System.out.println(1);
//        else if ( a % 2 == 0 && b % 2 == 0) System.out.println(pow( a, b, d,2));
//        else System.out.println("You must write even numbers");
//    }
//}
