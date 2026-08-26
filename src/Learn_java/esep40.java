package Learn_java;

import java.util.Scanner;

public class esep40 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = "Hello World";
        String[] ss = sentence.split(" ");

        int l = sentence.length() - 1;
        for(int i = l; i >= 0; i--){
            System.out.print(sentence.charAt(i));
        }System.out.println();

        for(int i = 0; i < ss.length; i++){
            StringBuilder sb = new StringBuilder(ss[i]);
            System.out.print(sb.reverse().toString());
            if (i < ss.length - 1) System.out.print(" ");
        }
        System.out.println();

        for(int i = ss.length - 1; i >= 0; i--){
            System.out.print(ss[i]);
            if(i > 0) System.out.print(" ");
        }
    }
}
