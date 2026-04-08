package Learn_java;

import java.util.Scanner;

public class esep11 {
    static void main(String[] args) {
        Scanner sc =   new Scanner(System.in);
        int  a ,b , c , form;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        form = (int) ((int) ((int) Math.pow(a, 3)+ 2 * Math.pow(b,2)) - 3 * a * b + Math.pow(c , 3));
        System.out.println(form);
    }
}
