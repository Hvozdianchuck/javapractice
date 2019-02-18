package multithreading;

import java.util.concurrent.Semaphore;

public class ExampleSemaphore {
    public static void main(String[] args) {
Semaphore table = new Semaphore(2);
Person person = new Person();
 Person person2 = new Person();
 Person person3 = new Person();
 person.table= table;
        person2.table= table;
        person3.table= table;
        person.start();
        person2.start();
        person3.start();
    }
}
class Person extends Thread{
    Semaphore table;
    @Override
    public void run() {
        System.out.println(this.getName()+"waiting fo table");
        try {
            table.acquire();
            System.out.println(this.getName()+"siting on the table");
            this.sleep(1000);
            table.release();
            System.out.println(this.getName()+"realize the table");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}