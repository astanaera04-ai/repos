package Learn_java;

public class esep50 {
    static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 3, 6, 5};
//        boolean b = false;

        outer:
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if (a[i] == a[j]) {
                    System.out.println(a[j]);
//                    b = true;
                    break outer;
                }
            }
//            if (b){
//                break;
//            }
        }
    }
}
