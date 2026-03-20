package alg_ass1;
//Task 3. Prime Number Check
//        Write a recursive function that checks whether a number n is
//        prime. A prime number is a number that is divisible only by 1 and
//        itself.
import java.util.Scanner;

public class Task3 {
    public static boolean isPrime(int a, int b){
        if (a % b == 0 && a > b ) return false;
        else if (a > b )    return isPrime( a ,b + 1 );
        else if (a <=  b ) {
            return true;
        }
        return true;
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a < 2) {
            System.out.println("Composite");}
        else if(isPrime(a , 2)){
            System.out.println("Prime");
        }
        else {
            System.out.println("Composite");
        }
    }
}
