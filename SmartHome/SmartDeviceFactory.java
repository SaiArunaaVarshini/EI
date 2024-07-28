public class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, int id, int initialTemp) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, initialTemp);
            case "door lock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}
