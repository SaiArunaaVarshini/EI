import java.util.ArrayList;
import java.util.List;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command 1
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command 2
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " is turned on.");
    }

    public void turnOff() {
        System.out.println(name + " is turned off.");
    }
}

// Invoker
class RemoteControl {
    private List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        commandHistory.add(command);
        command.execute();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room Light");
        Command turnOn = new TurnOnLightCommand(livingRoomLight);
        Command turnOff = new TurnOffLightCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        remote.executeCommand(turnOn);
        remote.executeCommand(turnOff);
    }
}
