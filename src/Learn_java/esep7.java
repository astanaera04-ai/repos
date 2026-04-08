package Learn_java;

import java.util.Scanner;

public class esep7 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b , c;
        a = sc.nextInt();
        b = sc.nextInt();

        c=a;
        a=b;
        b=c;
        System.out.println("a= " + a  );
        System.out.println("b = " + b);
    }
}
