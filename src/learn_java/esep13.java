package learn_java;

import java.util.Scanner;

public class esep13 {
    static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int x, y, z, form;
        x = sc.nextInt();
        y= sc.nextInt();
        z = sc.nextInt();
        form= (int) (Math.pow(x ,4) + 4 * x * Math.pow(y,2) - 4 * y * z + Math.pow(z , 4));
        System.out.println(form);
    }
}