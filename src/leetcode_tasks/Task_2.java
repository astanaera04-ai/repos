package leetcode_tasks;

import java.util.Scanner;
//Есеп: Екінші ең үлкен сан
//
//Пайдаланушы n сан енгізеді, содан кейін n бүтін сан беріледі.
//Сол массивтен екінші ең үлкен элементті тап.
public class Task_2 {
    public static int maxa(int[] arr){
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                second = max;
                max = arr[i];
            } else if(arr[i] > second && arr[i] != max){
                second = arr[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++ ){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxa(arr));

    }
}
