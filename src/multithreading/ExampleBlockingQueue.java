package multithreading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ExampleBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque= new PriorityBlockingQueue<>();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(""+blockingDeque.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(""+blockingDeque.add("one"));
            }
        }.start();
    }
}
