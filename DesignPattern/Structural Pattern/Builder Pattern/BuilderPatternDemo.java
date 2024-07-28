// Product class
class SmartHomeScene {
    private String lightSetting;
    private String lockSetting;
    private String thermostatSetting;

    private SmartHomeScene(Builder builder) {
        this.lightSetting = builder.lightSetting;
        this.lockSetting = builder.lockSetting;
        this.thermostatSetting = builder.thermostatSetting;
    }

    @Override
    public String toString() {
        return "SmartHomeScene [lightSetting=" + lightSetting + 
               ", lockSetting=" + lockSetting + 
               ", thermostatSetting=" + thermostatSetting + "]";
    }

    // Builder class
    public static class Builder {
        private String lightSetting;
        private String lockSetting;
        private String thermostatSetting;

        public Builder setLightSetting(String lightSetting) {
            this.lightSetting = lightSetting;
            return this;
        }

        public Builder setLockSetting(String lockSetting) {
            this.lockSetting = lockSetting;
            return this;
        }

        public Builder setThermostatSetting(String thermostatSetting) {
            this.thermostatSetting = thermostatSetting;
            return this;
        }

        public SmartHomeScene build() {
            return new SmartHomeScene(this);
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        SmartHomeScene morningScene = new SmartHomeScene.Builder()
            .setLightSetting("Dim")
            .setLockSetting("Unlocked")
            .setThermostatSetting("22°C")
            .build();

        SmartHomeScene nightScene = new SmartHomeScene.Builder()
            .setLightSetting("Off")
            .setLockSetting("Locked")
            .setThermostatSetting("18°C")
            .build();

        System.out.println(morningScene);
        System.out.println(nightScene);
    }
}
