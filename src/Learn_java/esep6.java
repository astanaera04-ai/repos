package Learn_java;

import java.util.Scanner;

public class esep6 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c , sum , minus, product;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        sum =a + b + c;
        minus = a - b - c ;
        product = a *b* c;
        System.out.println("a+b+c = "+sum );
        System.out.println("a-b-c = " + minus);
        System.out.println("a * b * c =" + product);
    }
}
