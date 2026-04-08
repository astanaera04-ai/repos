package Learn_java;

class esep17 {
    public static boolean isPalindrome(int x) {
        int big = x;
        int rev = 0;

        if (x < 0 ||(x % 10 == 0 && x != 0)){
            return false;
        }

        while(x > 0){
            rev =rev * 10 + x % 10;
            x = x / 10;
        }
        return rev == big;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}