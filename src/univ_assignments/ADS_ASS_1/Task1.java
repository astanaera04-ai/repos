package univ_assignments.ADS_ASS_1;
//Task 1. Print Digits of a Number"
//        Write a recursive function that takes an integer as input and
//        prints every digit of the given number on a separate line.

import java.util.Scanner;

public class Task1 {
    public static void dig(int a){

        if (a == 0) return ;
        dig(a / 10);
        System.out.println( a % 10 );
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        dig(a);

    }
}
