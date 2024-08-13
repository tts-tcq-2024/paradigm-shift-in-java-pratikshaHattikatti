package vitals;

public class Main {
    public static void main(String[] args) {
        BatteryChecker checker = new BatteryChecker("EN");
        
        // Test cases
        assert (checker.batteryIsOk(25, 70, 0.7f));
        assert (!checker.batteryIsOk(50, 85, 0.0f));

        System.out.println("All tests passed.");
    }
}
