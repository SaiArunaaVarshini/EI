public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int initialTemp) {
        super(id, "thermostat");
        this.temperature = initialTemp;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " is set to " + temperature + " degrees.");
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is already on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " cannot be turned off.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}
