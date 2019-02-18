package multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ExampleRandomAndTime {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ThreadLocalRandom.current().nextInt());
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));

    }
}
