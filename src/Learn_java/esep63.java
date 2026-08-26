package Learn_java;

public class esep63 {
    static void main(String[] args) {
        String a = "apple banana apple orange banana apple";
        String[] b = a.split(" ");
//        for (String d : b){
//            System.out.print(d + " ");
//        }
        int s = 0;
        int v = 0;
        int d = 0;
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b.length;j++){
                if (b[i].equals(b[j]) ){
                    s++;
                }
            }if(s > v){
                v = s;
                d = i;
            }
        }
        System.out.println(b[d]);
    }
}
