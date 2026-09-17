package Learn_java;

import java.util.Scanner;

public class esep66 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int s = 0;
        for (int i = 2; i < a; i++){
            for (int j = 2; j <= i; j++){
                if(i % j == 0){
                    s++;
                }
            }if (s == 1){

                System.out.println(i);
            }s = 0;
        }
    }
}
