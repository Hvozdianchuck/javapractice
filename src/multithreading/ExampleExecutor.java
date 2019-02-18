package multithreading;

import java.util.concurrent.*;

public class ExampleExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable2());
        System.out.println(executorService.submit(new MyCallable2()).get());
     executorService.shutdown();
    }
}
class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable");
    }
}
class MyCallable2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 3;
    }
}