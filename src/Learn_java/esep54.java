package Learn_java;

public class esep54 {
    static void main(String[] args) {
        int[] s = {2, 7, 11, 15};
        int target = 17;
        for (int i = 0; i < s.length; i++){
            for (int j = 0; j < s.length; j++){
                if (s[i] + s[j] == target){
                    System.out.println(i + " ; " + j);
                    break;

                }
            }
        }
    }
}
