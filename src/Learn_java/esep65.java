package Learn_java;

public class esep65 {
    static void main(String[] args) {
        String a = "listen";
        String b = "silent";
        boolean s = false;
        for (int i = 0; i < a.length(); i++){
            if (a.length() != b.length()){
                System.out.println("false");
                break;
            }
            for (int j = 0; j < b.length(); j++){
                if (a.charAt(i) == b.charAt(j)){
                    s = true;
                    break;
                }
            }if(!s){
                System.out.println("false");
                break;
            }
        }if (s){
            System.out.println("true");
        }
    }
}
