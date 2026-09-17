package Learn_java;

public class esep68 {
    static void main(String[] args) {
        int n = 3;
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                System.out.print(original[j][i] + " ");
            }
            System.out.println();
        }
    }
}
