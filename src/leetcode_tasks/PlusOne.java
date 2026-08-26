package leetcode_tasks;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] +=1;
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }

    static void main(String[] args) {
        int[] digits = {1 ,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
}}
