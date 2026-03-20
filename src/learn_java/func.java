package learn_java;

public class func {
     static int printN(int n) {

        if (n<= 1){
            return 1;
        }
        return n * printN(n-1) ;
    }

    static void main(String[] args) {
        int n=10;
        System.out.println(printN(n)   );

    }
}
