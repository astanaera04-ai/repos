package univ_assignments.ADS_ASS_1;
//Task 4. Factorial
//        Write a recursive function that calculates n! (factorial).

import java.util.Scanner;

public class Task4 {
    public static int fact(int a){
        if(a <=1){
            return 1;
        }
        return a * fact(a - 1);
    }
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println(fact(a));
    }
}
