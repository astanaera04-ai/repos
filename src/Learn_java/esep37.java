package Learn_java;

import java.util.Scanner;

public class esep37 {
    public static boolean isPrime(int a){
        if (a < 2) return false;

        for(int i = 2; i < a ; i++){
            if (a % i == 0){
                return false;
            }
        }
        return true;
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println(isPrime(a));

        for (int i = 1; i <= 100; i++){
            int b = 0;
            for (int j = 1; j <= 100; j++){
                if (i % j == 0){
                    b++;
                }
            }
            if(b == 2){
                System.out.println("prime namber:" + i);
            }
        }

    }
}
