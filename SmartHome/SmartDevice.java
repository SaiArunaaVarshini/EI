public abstract class SmartDevice {
    protected int id;
    protected String type;

    public SmartDevice(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract String getStatus();
}
