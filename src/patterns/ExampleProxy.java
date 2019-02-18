package patterns;

public class ExampleProxy {
    public static void main(String[] args) {
Computer computer = new ComputerProxy();
computer.play();
    }
}
interface Computer{
    void play();
}
class Lenovo implements Computer{
    @Override
    public void play() {
        System.out.println("play computer game");
    }
}
class ComputerProxy implements Computer{
Computer computer = new Lenovo();
    @Override
    public void play() {
        System.out.println("work programer");
        computer.play();
    }
}