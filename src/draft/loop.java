package draft;

public class loop {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 9, 4};
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println("-------");
        for (int n: numbers){
            System.out.println(n);
        }
        System.out.println("-------");
        int a = 0;
        while (a < numbers.length){
            if (numbers[a] % 2 == 0){
                System.out.println(numbers[a]);
            };
            a++;
        }

        System.out.println("----------");
        a = 0;
        int b = 0;
        while (a < numbers.length){
            if (b <= numbers[a]){
                b = numbers[a];
            }
            a++;
        }
        System.out.println(b);
    }
}
