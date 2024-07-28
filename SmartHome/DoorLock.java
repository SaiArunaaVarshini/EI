public class DoorLock extends SmartDevice {
    private boolean isLocked;

    public DoorLock(int id) {
        super(id, "door lock");
        this.isLocked = true;
    }

    @Override
    public void turnOn() {
        isLocked = false;
        System.out.println("Door lock " + id + " is unlocked.");
    }

    @Override
    public void turnOff() {
        isLocked = true;
        System.out.println("Door lock " + id + " is locked.");
    }

    @Override
    public String getStatus() {
        return "Door lock " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }
}
