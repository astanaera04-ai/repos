package Footballers;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
//        int i =1;
//        do {
//            System.out.println(i+" ");
//            i*=2;
//
//
//        }while(i<20);

        Footballer f1 = new Footballer(1,"Bek" , "Orazbek");
        Footballer f2 = new Footballer(2 , "Beko", "Urazbek");
        ArrayList<Footballer> footballers = new ArrayList<>();
        footballers.add(f2);
        footballers.add(f1);

//        f1.id = 1;
//        f1.name = "bek";
//        f1.surname = "or";

        f2.getinfo();

        Club kairat = new Club();
        kairat.clubName="Kairat";
        kairat.state = "kaz";
    }
}
