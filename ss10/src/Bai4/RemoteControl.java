package Bai4;

public interface RemoteControl {
    void powerOn();

    default void checkBattery() {
        System.out.println("Pin ổn định");
    }
}

