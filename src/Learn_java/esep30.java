package Learn_java;

import java.util.Arrays;

public class esep30 {
    public void reverseString(String[] s){
        int t= s.length-1 ;
        for(int i =0; i < s.length ;i++){
            if (i < s.length/2){
                String temp = s[i];
                s[i] = s[t-i];
                s[t-i] = (String) temp;
            }
            else{
                break;
            }
        }
}

    static void main(String[] args) {
        esep30 esep = new esep30();
        String[] s = { "h","e","l","l","o" };
        esep.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
