package Learn_java;

import java.util.Arrays;

public class esep26 {

    public static void reverseString(char[] s){

        int l = 0;
        int r = s.length - 1;
        while (r > l){
            char a = s[l];
            s[l] = s[r];
            s[r] = a ;
            l++;
            r--;
        }

    }

    static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        System.out.println("Бастапқы сөз: " + Arrays.toString(s));

        reverseString(s);

        System.out.println("Кері айналған сөз: " + Arrays.toString(s));
    }

}
