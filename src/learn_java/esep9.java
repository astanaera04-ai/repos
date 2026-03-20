package learn_java;

import java.util.Scanner;

public class esep9 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, sum;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        a = a * 2;
        b = b - 2;
        c = (int) Math.pow(c,3);
        sum = a + b + c;
        System.out.println(sum);
    }
}
