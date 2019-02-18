package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExampleCyclicBarier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
        new Sportmen(cyclicBarrier).start();
        new Sportmen(cyclicBarrier).start();
        new Sportmen(cyclicBarrier).start();

    }
static class Run extends Thread{
    @Override
    public void run() {
        System.out.println("running");
    }
}
static class Sportmen extends Thread{
    CyclicBarrier cyclicBarrier;
    public Sportmen(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("ready to run");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
}
