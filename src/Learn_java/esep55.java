package Learn_java;

public class esep55 {
    static void main(String[] args) {
        int[] a = {-3, 1, -2, 4, 5};
        int s = 0;
        for(int i = 0; i < a.length; i++){
            if (a[i] > 0 ){
                s += a[i];
            }
        } System.out.println(s);
    }
}
