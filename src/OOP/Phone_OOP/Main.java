package OOP.Phone_OOP;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone  = new SmartPhone("iPhone", 89, 128);
//        phone.call();
//        phone.connect();
//        phone.installApp("WhatsApp");
//        phone.showBattery();
//        phone.charge(15);
//        phone.connect();

        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new SmartPhone("Iphone", 55, 128));
        phones.add(new BasicPhone("Nokia", 75, "Kcell"));
        phones.add(new BasicPhone("Sony", 65, "Beeline"));
        phones.add(new SmartPhone("Iphone", 55, 8));

        try{
            phone.charge(-10);
        } catch (InvalidBatteryException e){
            System.out.println("❌ Зарядтау мөлшері 0-ден көп болуы керек!");
        }
        System.out.println("=== Барлық телефондар ===");
        for (Phone p : phones){
            p.call();
            p.connect();
            System.out.println();
        }

    }
}
