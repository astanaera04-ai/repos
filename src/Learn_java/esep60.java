package Learn_java;

public class esep60 {
    static void main(String[] args) {
        int[] a ={3, 1, 4, 1, 5, 9};
        int s = -99;
        int c = -99;
        for (int i = 0; i < a.length; i++){
            if(s < a[i]){
                c = s;
                s=a[i];
            }
        }
        System.out.println(c);
    }
}
