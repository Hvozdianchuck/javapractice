package multithreading;

import java.util.concurrent.CountDownLatch;

public class ExampleCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);
        countDownLatch.await();
    }
}
class Work extends Thread{
    CountDownLatch countDownLatch;
    public Work(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work done");
        countDownLatch.countDown();
    }
}
