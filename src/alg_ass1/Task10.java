package alg_ass1;
//Task 10. Greatest Common Divisor (GCD)
//        Write a recursive function that finds the GCD of two numbers
//        using the Euclidean Algorithm.
import java.util.Scanner;
//        if (b == 0) return a;
//        return gcd(b, a % b);

public class Task10 {
    public static int gcd(int a, int b, int c){
        if (a % c == 0 && b % c == 0) return c;
        else {
            return gcd(a, b, c - 1);
        }
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c;
        if (a > b) {
            c = b;
            System.out.println(gcd(a, b, c));
        }
        else {
            c = a;
            System.out.println(gcd(a, b, c));
        }
    }
}
