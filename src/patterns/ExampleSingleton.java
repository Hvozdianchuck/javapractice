package patterns;

public class ExampleSingleton {
    public static void main(String[] args) {
Worker worker = Worker.getInstance();
worker.work();
    }
}
class Worker{
   static Worker worker = new Worker();
    private Worker(){}
    public static Worker getInstance(){
        return worker;
    }
    void work(){
        System.out.println("work");
    }
}