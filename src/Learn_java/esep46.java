package Learn_java;

import java.util.Scanner;

public class esep46 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sen = sc.nextLine();
        String rev = new StringBuilder(sen).reverse().toString();

        sen = sen.toLowerCase();
        sen = sen.replace(" ", "");

        int l = sen.length() - 1;
        boolean isPalindrome = true;
        for(int i = 0; i < sen.length() / 2; i++){
            if (sen.charAt(i) != sen.charAt(l)) {
                isPalindrome = false;
                break;
            }
            l--;
        }
        if(isPalindrome){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
