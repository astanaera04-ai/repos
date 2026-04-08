package univ_assignments.ADS_ASS_1;
//Task 7. Reverse Output
//        You are given n numbers. Write a recursive function that reads
//        and prints the numbers in reverse order without using another
//        array.
import java.util.Scanner;

public class Task7 {
    static Scanner sc = new Scanner(System.in);

    public static void rev(int n){

            if(n == 0) return;

            int a = sc.nextInt();
            rev(n-1);
            System.out.println(a);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        rev(n);
    }
}
