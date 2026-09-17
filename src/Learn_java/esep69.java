package Learn_java;

public class esep69 {
    static void main(String[] args) {
        int n = 3;
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n-1-i] = original[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
