import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Device {
    void update(String message);
}

// Concrete Observer 1
class SmartLight implements Device {
    private String name;

    public SmartLight(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Concrete Observer 2
class SmartLock implements Device {
    private String name;

    public SmartLock(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Subject Interface
interface SecuritySystem {
    void addObserver(Device device);
    void removeObserver(Device device);
    void notifyObservers();
}

// Concrete Subject
class HomeSecuritySystem implements SecuritySystem {
    private List<Device> devices = new ArrayList<>();
    private String message;

    @Override
    public void addObserver(Device device) {
        devices.add(device);
    }

    @Override
    public void removeObserver(Device device) {
        devices.remove(device);
    }

    @Override
    public void notifyObservers() {
        for (Device device : devices) {
            device.update(message);
        }
    }

    public void intrusionDetected() {
        this.message = "Intrusion detected!";
        notifyObservers();
    }
}


public class ObserverPatternDemo {
    public static void main(String[] args) {
        HomeSecuritySystem securitySystem = new HomeSecuritySystem();

        Device light1 = new SmartLight("Living Room Light");
        Device lock1 = new SmartLock("Main Door Lock");

        securitySystem.addObserver(light1);
        securitySystem.addObserver(lock1);

        securitySystem.intrusionDetected();
    }
}
