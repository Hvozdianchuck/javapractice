package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ExampleCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
Callable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());//work as join()
    }
}
class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i=0;
        for (int j=0; j<10; j++, i++){
            Thread.sleep(1000);
        }

        return i;
    }
}