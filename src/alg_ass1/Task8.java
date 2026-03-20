package alg_ass1;
//Task 8. Check Digits in String
//        You are given a string s. Write a recursive function that
//        checks whether the string contains only digits.
//Return "Yes" if
//        all characters are digits, otherwise return "No".
import java.util.Scanner;

public class Task8 {

    public static String isDig( String s, int i){
        if (i == s.length()) return "Yes";                    // барлығы тексерілді → Yes
        else if (Character.isDigit(s.charAt(i))) {                                 // цифр → жалғастыр
            return isDig(s, i + 1);
        }
        else return "No";
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0;

        System.out.println(isDig(s , i));
    }
}
