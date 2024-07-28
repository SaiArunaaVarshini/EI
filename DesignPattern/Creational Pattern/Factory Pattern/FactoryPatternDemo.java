// Device Interface
interface Device {
    void performAction(String action);
}

// Concrete Device 1
class Light implements Device {
    @Override
    public void performAction(String action) {
        System.out.println("Light is turned " + action);
    }
}

// Concrete Device 2
class Lock implements Device {
    @Override
    public void performAction(String action) {
        System.out.println("Lock is " + action);
    }
}

// Concrete Device 3
class Thermostat implements Device {
    @Override
    public void performAction(String action) {
        System.out.println("Thermostat is set to " + action);
    }
}

// Factory Class
class DeviceFactory {
    public static Device createDevice(String deviceType) {
        switch (deviceType) {
            case "Light":
                return new Light();
            case "Lock":
                return new Lock();
            case "Thermostat":
                return new Thermostat();
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}


public class FactoryPatternDemo {
    public static void main(String[] args) {
        Device light = DeviceFactory.createDevice("Light");
        Device lock = DeviceFactory.createDevice("Lock");
        Device thermostat = DeviceFactory.createDevice("Thermostat");

        light.performAction("ON");
        lock.performAction("UNLOCKED");
        thermostat.performAction("22°C");
    }
}
