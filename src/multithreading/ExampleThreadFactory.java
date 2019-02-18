package multithreading;

import java.util.concurrent.ThreadFactory;

public class ExampleThreadFactory {
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                 thread.setPriority(9);
                return thread;
            }
        };
        Thread thread= factory.newThread(new Thread2());
        thread.start();
    }
    static  class Thread2 extends Thread{
        @Override
       public void run(){
            System.out.println("new thread");
        }
    }
}
