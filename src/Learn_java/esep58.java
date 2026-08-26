package Learn_java;

import java.util.LinkedList;

public class esep58 {
    static void main(String[] args) {
        LinkedList<Integer > a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        for (int i = 0; i < a.size(); i++){
            for (int j = 1; j < a.size(); j++){
                if (a.get(i) .equals(a.get(j)) ){
                    a.remove(a.get(j));
                }
        }
    }
        System.out.println(a);
}}
