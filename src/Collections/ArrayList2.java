package Collections;
import java.util.ArrayList;
import java.util.List;
public class ArrayList2 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(3);
        a.add(8);
        a.add(1);
        a.add(9);
        a.add(2);

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) % 2 != 0){
                System.out.println(a);
                a.remove(Integer.valueOf(a.get(i)));
                i--;
            }
        }
        System.out.println(a);
    }
}
