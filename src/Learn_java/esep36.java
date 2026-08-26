package Learn_java;

import java.util.Scanner;

public class esep36 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        int c = sc.nextInt();

        switch (b){
            case "+":
                System.out.println(a + c);
                break;
            case "-":
                System.out.println(a - c);
                break;
            case "*":
                System.out.println(a * c);
                break;
            case "/":
                if (c == 0){
                    System.out.println("⚠\uFE0F your job — handle division by zero here!");
                }
                else {
                    System.out.println(a / c);
                }break;
            default:
                System.out.println("Unknown operator");
        }
    }
}
