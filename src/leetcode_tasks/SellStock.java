package leetcode_tasks;

import java.util.Arrays;

public class SellStock {
    public static int maxProfit(int[] prices) {
        int a = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length ; j++){
                if ( prices[j]-prices[i]  > a){
                    a = prices[j]-prices[i];
                }
            }
        }
        if(a > 0){
            return a;
        }else {
            return 0;
        }

    }

    static void main(String[] args) {
        int[] prices = {1 , 2};
        System.out.println(maxProfit(prices));
    }
}
