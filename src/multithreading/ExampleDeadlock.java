package multithreading;

public class ExampleDeadlock {
    public static void main(String[] args) {
ResourseA resourseA = new ResourseA();
ResourseB resourseB = new ResourseB();
ExampleThread1 exampleThread1 = new ExampleThread1();
ExampleThread2 exampleThread2 = new ExampleThread2();
resourseA.resourseB=resourseB;
resourseB.resourseA=resourseA;
exampleThread1.resourseA=resourseA;
exampleThread2.resourseB=resourseB;
exampleThread1.start();
exampleThread2.start();

    }
}
class ExampleThread1 extends Thread{
    ResourseA resourseA;
    @Override
    public void run() {
        System.out.println(resourseA.getI());
    }
}
class ExampleThread2 extends Thread{
    ResourseB resourseB;
    @Override
    public void run() {
        System.out.println(resourseB.getI());
    }
}
class ResourseA{
    ResourseB resourseB;
    public synchronized int getI(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resourseB.returnB();
    }
    public synchronized int returnA(){
        return 1;
    }
    }

class ResourseB{
    ResourseA resourseA;
    public synchronized int getI(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resourseA.returnA();
    }
    public synchronized int returnB(){
        return 1;
    }
}
