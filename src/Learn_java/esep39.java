package Learn_java;

import java.util.Scanner;

public class esep39 {
    public static int Sum(int[] n){
        int a = 0;
        for(int i = 0; i < n.length; i++){
            a = a + n[i];
        }
        return a;
    }
    static void main(String[] args) {
        int[] n = new int[5];

        for ( int i = 0; i < n.length;i++){
            Scanner sc =  new Scanner(System.in);
            n[i] = sc.nextInt();
        }
        System.out.println("Sum of the array:" + Sum(n));

        System.out.println("Average: " + Sum(n) / n.length);

        int s = n[0];
        int b = n[0];
        for (int i = 1; i < n.length; i++){
            if(s <= n[i]){
                s = n[i];
            }
            if(b >= n[i]){
                b = n[i];
            }
        }
        System.out.println("max namber:" + s);
        System.out.println("min namber:" + b);

        System.out.print("All numbers greater than the average:");
        for (int i = 0; i < n.length; i++){
            if (Sum(n) / n.length < n[i]){
                System.out.print(n[i] + " ");
            }
        }
    }
}
