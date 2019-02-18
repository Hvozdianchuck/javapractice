package patterns;

public class ExampleTemplate {
    public static void main(String[] args) {
Job job = new Job();
job.run();
    }
}
abstract class Template{
   abstract void stepOne();
   abstract void stepTwo();
   abstract void stepThree();
   void run(){
       stepOne();
       stepTwo();
       stepThree();
   }
}
class Job extends Template{

    @Override
    void stepOne() {
        System.out.println("step one");
    }

    @Override
    void stepTwo() {
        System.out.println("step two");
    }

    @Override
    void stepThree() {
        System.out.println("step three");
    }
}