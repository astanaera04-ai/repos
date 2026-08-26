package Collections;
import java.util.Collections;
import java.util.ArrayList;

//Array vs ArrayList:
//Array	                ArrayList
//Өлшемі	   Тіркелген	         Динамикалық
//Түрі	       Примитив + объект	 Тек объект
//Жылдамдығы   Жылдам	             Баяулау
//Әдістер      Жоқ	                 Көп (add, remove...)
//Жариялау	   int[]	                 ArrayList<Integer>
public class ArrayArrayList {
    static void main(String[] args) {

        int[] numbers = new int[2];
        numbers[0] = 1;
        numbers[1] = 2;

        int[] numbers2 = {1, 2, 3, 4, 5};

        ArrayList<Integer> numbers3 = new ArrayList<>();

        numbers3.add(10);
        numbers3.add(20);
        numbers3.add(30);
        numbers3.add(40);

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println("---------");

        for (int i = 0; i < numbers3.size(); i++){
            System.out.println(numbers3.get(i));
        }
        System.out.println("---------");

        for (int b : numbers){
            System.out.println(b);
        }

        System.out.println("---------");
        for (int s: numbers3){
            System.out.println(s);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("Алибек");
        list.add("Айша");
        list.add("Нұрлан");

        list.remove("Айша");

        list.contains("Алибек"); // true

        Collections.sort(list);

        Collections.reverse(list);

    }
}
