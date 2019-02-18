package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommand {
    public static void main(String[] args) {
Receiver receiver = new Receiver();
receiver.RunComand();
receiver.addCommand(new MouseClick());
receiver.addCommand(new KeyBoard());
        System.out.println(receiver.getCommand(1));
    }
}
interface Command{
    void execute();
}
class MouseClick implements Command{
    @Override
    public void execute() {
        System.out.println("mouse click");
    }
}
class KeyBoard implements Command{
    @Override
    public void execute() {
        System.out.println("keyboard");
    }
}
class Receiver{
    Command command = new MouseClick();
    List<Command> list = new ArrayList<>();
    void RunComand(){
        command.execute();
    }
    void addCommand(Command command){
        list.add(command);
    }
    Command getCommand(int i){
       return list.get(i);
    }
}