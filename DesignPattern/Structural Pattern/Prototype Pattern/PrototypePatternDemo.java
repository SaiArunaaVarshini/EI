// Prototype interface
interface Device extends Cloneable {
    Device clone();
    void setSetting(String setting);
    void showSetting();
}

// Concrete Prototype 1
class Light implements Device {
    private String setting;

    public Light(String setting) {
        this.setting = setting;
    }

    @Override
    public Device clone() {
        return new Light(this.setting);
    }

    @Override
    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public void showSetting() {
        System.out.println("Light setting: " + setting);
    }
}

// Concrete Prototype 2
class Thermostat implements Device {
    private String setting;

    public Thermostat(String setting) {
        this.setting = setting;
    }

    @Override
    public Device clone() {
        return new Thermostat(this.setting);
    }

    @Override
    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public void showSetting() {
        System.out.println("Thermostat setting: " + setting);
    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) {
        Light originalLight = new Light("Bright");
        Thermostat originalThermostat = new Thermostat("22°C");

        Light clonedLight = (Light) originalLight.clone();
        Thermostat clonedThermostat = (Thermostat) originalThermostat.clone();

        clonedLight.setSetting("Dim");
        clonedThermostat.setSetting("18°C");

        originalLight.showSetting();
        clonedLight.showSetting();

        originalThermostat.showSetting();
        clonedThermostat.showSetting();
    }
}
