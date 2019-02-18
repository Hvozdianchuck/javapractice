package multithreading;

public class ExampleWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify();
        waitNotify.start();
        synchronized (waitNotify){
           waitNotify.wait();
        }
        System.out.println(waitNotify.total);

    }
    static class WaitNotify extends Thread{
        int total;
        @Override
        public void run() {
            synchronized (this){
                for (int i=0;i<5;i++){
                    total+=i;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}
