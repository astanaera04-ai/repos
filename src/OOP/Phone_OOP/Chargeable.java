package OOP.Phone_OOP;

public interface Chargeable {
    void charge(int amount) throws InvalidBatteryException;
    void showBattery();
}
