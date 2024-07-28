// Singleton class for SmartHomeController
class SmartHomeController {
    private static SmartHomeController instance;

    private SmartHomeController() {
        // private constructor to prevent instantiation
    }

    public static SmartHomeController getInstance() {
        if (instance == null) {
            synchronized (SmartHomeController.class) {
                if (instance == null) {
                    instance = new SmartHomeController();
                }
            }
        }
        return instance;
    }

    public void controlDevice(String deviceName, String action) {
        System.out.println("Controlling " + deviceName + " to perform action: " + action);
    }
}


public class SingletonPatternDemo {
    public static void main(String[] args) {
        SmartHomeController controller1 = SmartHomeController.getInstance();
        SmartHomeController controller2 = SmartHomeController.getInstance();

        controller1.controlDevice("Living Room Light", "ON");
        controller2.controlDevice("Thermostat", "SET TO 22°C");

        // Verifying both references point to the same instance
        System.out.println(controller1 == controller2);  // true
    }
}
