package Learn_java;

public class esep49 {
    static void main(String[] args) {
        int[] arr = {1 ,2 ,3, 4 ,5 ,6 };
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr [l] % 2 !=0){
                int t = arr[r];
                arr[r] = arr[l];
                arr[l] = t;
                r--;
            }else {
                l++;
            }
        }
        for (int i = 0; i < arr.length; i++ ){
            System.out.println(arr[i]);
        }
    }
}
