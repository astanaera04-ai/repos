package univ_assignments.ADS_ASS_1;

import java.util.Scanner;

public class Task_11 {
    public static boolean isPrime(int a, int b){
       if (a % b == 0 && a > b) return true;
       else if (a > b) return isPrime(a, b + 1);
       return false;

    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (isPrime(a,2)) System.out.println("Composite");
        else System.out.println("Prime");
    }
}
