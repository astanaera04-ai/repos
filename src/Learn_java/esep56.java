package Learn_java;

public class esep56 {
    static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int s = 0;
        int d = 0;
        for (int i = 0; i < a.length;i++){
            if(a[i] % 2 == 0) s++;
            else d++;
        }
        System.out.println("Even: " + s);
        System.out.println("Odd: " + d );
    }
}
