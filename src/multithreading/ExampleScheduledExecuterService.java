package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExampleScheduledExecuterService {
    public static void main(String[] args) {
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
service.schedule(new MyThreadScheduler(), 3, TimeUnit.SECONDS);
service.shutdown();
    }
}
class MyThreadScheduler extends Thread{
    @Override
    public void run() {
        System.out.println(3);
    }
}