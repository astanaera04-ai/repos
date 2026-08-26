package Learn_java;

import java.util.Scanner;

public class esep43 {
    static void main(String[] args) {

        String[] ones = {"", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"};

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //int number = 247;

        int hun = number / 100;
        int rem = number % 100;
        int ten = rem / 10;
        int one = rem % 10;

        String result = "";
        if (hun > 0){
            result +=ones[hun] + " hundred ";
        }if (ten > 0){
            result += tens[ten] + " ";
        }
        if (one > 0){
            result += ones[one];
        }
        System.out.println(result.trim());
    }
}
