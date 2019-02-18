package advanced2;

public class ExampleThreadLocal {
    static  ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
    threadLocal.set("hello world");
    Thread one = new ThreadOne();
    Thread two = new ThreadTwo();
    one.start();
    two.start();
    one.join();
    two.join();
        System.out.println(threadLocal.get());
    }
    static  class ThreadTwo extends Thread{

        @Override
        public void run() {
            threadLocal.set("TreadTwo");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TreadTwo" +threadLocal.get());
        }
    }
    static  class ThreadOne extends Thread{
        @Override
        public void run() {
           threadLocal.set("TreadOne");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadOne" +threadLocal.get());
        }
    }
}
