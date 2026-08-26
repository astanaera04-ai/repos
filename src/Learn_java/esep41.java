package Learn_java;

import java.util.Scanner;

public class esep41 {
    static void main(String[] args) {
        String[] names = new String[5];
        int[] scores = new int[5];


        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < names.length; i++){


            System.out.print("Inter the student's name:");
            names[i] = sc.nextLine();

            sc.nextLine();

            System.out.println("Inter the student's score:");
            scores[i] = sc.nextInt();
        }
        for (int i = 0; i < names.length; i++){
            if (scores[i] >= 90) System.out.println("Student name:" + names[i] + "   sroce:" + scores[i] +  "   grade:A");
            else if (scores[i] >= 80) System.out.println("Student name:" + names[i] + "   sroce:" + scores[i] +  "   grade:B");
            else if (scores[i] >= 70) System.out.println("Student name:" + names[i] + "   sroce:" + scores[i] +  "   grade:C");
            else if (scores[i] >= 60) System.out.println("Student name:" + names[i] + "   sroce:" + scores[i] +  "   grade:D");
            else if (scores[i] < 60) System.out.println("Student name:" + names[i] + "   sroce:" + scores[i] +  "   grade:F");
        }
        int a = 0;
        for (int i = 0; i < scores.length; i++){
            a += scores[i];
        }
        System.out.println("Calculate and print average:" + a / scores.length);

        int b = scores[0];
        for (int i = 1; i < names.length; i++){
            if(b <= scores[i]) b = scores[i];
        }for (int i = 0; i < names.length; i++){
            if(b == scores[i]) System.out.println("Find and print top student:" + names[i] + "  Score:" + scores[i]);
        }

    }
}
