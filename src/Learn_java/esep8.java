package Learn_java;

import java.util.Scanner;

public class esep8 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int a, kv, kub ;
        a=sc.nextInt();
        kv = (int) Math.pow(a, 2);
        kub = (int) Math.pow(a , 3);
        System.out.println("a**2 = "+kv);
        System.out.println("a**3 = "+kub);
    }

}
