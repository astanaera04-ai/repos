package OOP.Phone_OOP;

public class BasicPhone extends Phone{
    String simCard;

    public BasicPhone(String brand, int batery, String simCard){
        super(brand, batery);
        this.simCard = simCard;
    }

    @Override
    public void connect() {
        System.out.println(simCard + " тек 2G-ге қосылды! \uD83D\uDCF6");
    }
}
