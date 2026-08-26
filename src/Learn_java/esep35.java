package Learn_java;
import java.util.Random;
import java.util.Scanner;

public class esep35 {
    static void main(String[] args) {
        Random rand  = new Random();
        int r = rand.nextInt(100) + 1;
        System.out.println("Random namber:" + r);

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        while (a != r){
            if (a < r){
                System.out.println("Too low");
                System.out.print("Try again:");
                a = sc.nextInt();
            } else  {
                System.out.println("Too high");
                System.out.print("Try again:");
                a = sc.nextInt();
            }
        }System.out.println("Corect");


    }
}
