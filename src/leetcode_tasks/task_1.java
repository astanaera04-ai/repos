package leetcode_tasks;

import java.util.Scanner;

public class task_1 {
    public static int sum(int a, int s){

        while (a != 0){
            s +=a%10;
            a /=10;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(sum(a, 0));
    }
}
