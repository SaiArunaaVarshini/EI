import java.util.ArrayList;
import java.util.List;

public class SmartHomeSystem {
    private List<SmartDevice> devices = new ArrayList<>();
    private List<ScheduledTask> scheduledTasks = new ArrayList<>();
    private List<AutomationTrigger> automationTriggers = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println("Added " + device.getType() + " with ID " + device.getId());
    }

    public void removeDevice(int id) {
        devices.removeIf(device -> device.getId() == id);
        System.out.println("Removed device with ID " + id);
    }

    public void turnOn(int id) {
        devices.stream().filter(device -> device.getId() == id).forEach(SmartDevice::turnOn);
        notifyObservers();
    }

    public void turnOff(int id) {
        devices.stream().filter(device -> device.getId() == id).forEach(SmartDevice::turnOff);
        notifyObservers();
    }

    public void setSchedule(int id, String time, String command) {
        scheduledTasks.add(new ScheduledTask(id, time, command));
        System.out.println("Scheduled " + command + " for device " + id + " at " + time);
    }

    public void addTrigger(String condition, String operator, int value, String action) {
        automationTriggers.add(new AutomationTrigger(condition, operator, value, action));
        System.out.println("Added automation trigger: " + condition + " " + operator + " " + value + " -> " + action);
    }

    public String getStatusReport() {
        StringBuilder statusReport = new StringBuilder();
        for (SmartDevice device : devices) {
            statusReport.append(device.getStatus()).append(". ");
        }
        return statusReport.toString();
    }

    public String getScheduledTasks() {
        StringBuilder scheduleReport = new StringBuilder("[");
        for (ScheduledTask task : scheduledTasks) {
            scheduleReport.append(task).append(", ");
        }
        if (!scheduledTasks.isEmpty()) {
            scheduleReport.setLength(scheduleReport.length() - 2); // Remove the last comma and space
        }
        scheduleReport.append("]");
        return scheduleReport.toString();
    }

    public String getAutomatedTriggers() {
        StringBuilder triggerReport = new StringBuilder("[");
        for (AutomationTrigger trigger : automationTriggers) {
            triggerReport.append(trigger).append(", ");
        }
        if (!automationTriggers.isEmpty()) {
            triggerReport.setLength(triggerReport.length() - 2); // Remove the last comma and space
        }
        triggerReport.append("]");
        return triggerReport.toString();
    }

    private void notifyObservers() {
        for (AutomationTrigger trigger : automationTriggers) {
            // Simulate trigger conditions and actions.
            System.out.println("Checking trigger: " + trigger);
        }
    }

    public static void main(String[] args) {
        SmartHomeSystem system = new SmartHomeSystem();
        SmartDeviceFactory factory = new SmartDeviceFactory();

        SmartDevice light = factory.createDevice("light", 1, 0);
        SmartDevice thermostat = factory.createDevice("thermostat", 2, 70);
        SmartDevice doorLock = factory.createDevice("door lock", 3, 0);

        system.addDevice(light);
        system.addDevice(thermostat);
        system.addDevice(doorLock);

        system.turnOn(1);
        system.setSchedule(2, "06:00", "Turn On");
        system.addTrigger("temperature", ">", 75, "turnOff(1)");

        System.out.println("Status Report: " + system.getStatusReport());
        System.out.println("Scheduled Tasks: " + system.getScheduledTasks());
        System.out.println("Automated Triggers: " + system.getAutomatedTriggers());
    }
}
