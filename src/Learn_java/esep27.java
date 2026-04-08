package Learn_java;

public class esep27 {

    public static boolean isPalindrome(String a){
        int l = 0;
        int r = a.length() - 1;

        while (r > l){
            char ll = a.charAt(l);
            char rr = a.charAt(r);

            if (!Character.isLetterOrDigit(ll)){
                l++;
            }

            else if(!Character.isLetterOrDigit(rr)){
                r--;
            }

            else if(Character.toLowerCase(a.charAt(l)) != Character.toLowerCase(a.charAt(r)) ){
                return false;
            } else {
                l++;
                r--;
            }

        }
        return true;
    }

    static void main(String[] args) {
        String t1 = "A man, a plan, a canal: Panama";
        String t2 = "race a car";

        System.out.println("1-тест: " + isPalindrome(t1));
        System.out.println("2-тест: " + isPalindrome(t2));
    }
}
