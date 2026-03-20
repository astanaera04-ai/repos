package alg_ass1;
//Task 2. Average of Elements
//        Write a recursive function to calculate the sum of the
//        elements, then compute the average using the result.
import java.util.Scanner;

public class Task2 {
    public static int sum(int[] arr, int i ){
        if (i == arr.length){
            return 0;
        }
        return arr[ i ] + sum(arr, i + 1);
    }
    public static double average( int [] arr){
        return (double) sum(arr,0) / arr.length;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];

        for ( int i = 0; i < a; i++){
            arr[i] = sc.nextInt();
        }
        System.out.printf("Average: %.2f%n", average(arr));
    }


}