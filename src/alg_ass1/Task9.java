package alg_ass1;
//Task 9. Count Characters in a String
//        Write a recursive function that counts the number of characters in a
//        given string. The function should return the total number of characters
//        in the string.
import java.util.Scanner;

public class Task9 {
    public static int leng(String a, int i){
        if ( i == a.length()) return 0;
        return 1 + leng(a, i + 1);
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(leng(a, 0));
    }
}
