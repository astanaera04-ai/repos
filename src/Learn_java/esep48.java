package Learn_java;

public class esep48 {
    static void main(String[] args) {
        int[] arr = {1 , 2 ,3 ,4 ,5};
        int l = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++){
            int ll = arr[i];
            arr[i] = arr[l];
            arr[l] = ll;
            l--;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
