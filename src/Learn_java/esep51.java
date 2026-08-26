package Learn_java;

import java.util.Scanner;

public class esep51{
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        shift = ((shift % 26) + 26) % 26;

        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result += (char) ((c - 'a' + shift) % 26 + 'a');
            }}}}