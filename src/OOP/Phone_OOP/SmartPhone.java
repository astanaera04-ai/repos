package OOP.Phone_OOP;

public class SmartPhone extends Phone implements Chargeable{
    int ram;

    public SmartPhone(String brand, int batery, int ram){
        super(brand,batery);
        this.ram = ram;
    }

    @Override
    public void connect() {
        System.out.println(getBrand()  + " 5G интернетке қосылды! 🌐");
    }

    @Override
    public void showBattery() {

        if (getBatery() >= 100){
            System.out.println("Батарея деңгейі: 100%");
        }else {
            System.out.println("Батарея деңгейі: " + getBatery() + " %");

        }


    }
    @Override
    public void charge(int amount) throws InvalidBatteryException {
        if (amount <= 0){
            throw new InvalidBatteryException(
                    "❌ Зарядтау мөлшері 0-ден көп болуы керек!"
            );
        }
        setBatery(getBatery() + amount);
        if (getBatery() >= 100) {
            System.out.println("Батарея толық: 100% ✅");
        } else {
            System.out.println(getBrand() + " зарядталуда... ⚡ Батарея: " + getBatery()+ " %");
        }
    }


    public void installApp(String AppName){

        System.out.println("Batery: " + getBatery() +  " %");
        System.out.println(getBrand()  + " -ға " + AppName + " орнатылды! \uD83D\uDCF1");
        System.out.println("Ram: " + ram + " GB");
    }

}
