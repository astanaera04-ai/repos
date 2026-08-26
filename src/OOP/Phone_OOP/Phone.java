package OOP.Phone_OOP;

public abstract class Phone {
    private String brand;
    private int batery;

    public Phone(String brand,int batery){
        this.batery = batery;
        this.brand = brand;
    }
    public int getBatery(){
        return batery;
    }
    public String getBrand(){
        return brand;
    }

    public void setBatery(int batery) {
        if (batery >= 0 && batery <= 100){
            this.batery = batery;
        }else {
            System.out.println("❌ Батарея 0-100 арасында болуы керек!");
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void call(){
        System.out.println(brand + " қоңырау шалуда... \uD83D\uDCDE");
    }
    public abstract void connect();
}

