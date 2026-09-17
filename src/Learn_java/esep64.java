package Learn_java;

import java.util.Scanner;

public class esep64 {
    static void main(String[] args) {
        int a = 12345;
        int s = 0;
        while (a > 0){
            s += a % 10;
            a /= 10;
        }
        System.out.println(s);
    }
}
