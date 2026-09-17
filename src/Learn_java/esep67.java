package Learn_java;

import static java.lang.Math.max;

public class esep67 {
    static void main(String[] args) {

        int[] a  = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int currentSum = a[0];
        int maxSum = a[0];

        for (int i = 0; i < a.length; i++){
             currentSum = max(a[i], currentSum + a[i]);
            maxSum = max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
