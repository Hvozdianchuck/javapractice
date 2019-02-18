package multithreading;

import java.util.concurrent.Exchanger;

public class ExampleExchenger {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        Mike mike = new Mike(exchanger);
        Sam sam = new Sam(exchanger);
        mike.start();
        sam.start();
}}
class Mike extends Thread{
    Exchanger exchanger;
    public Mike(Exchanger exchanger){
        this.exchanger= exchanger;
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            exchanger.exchange("Sam");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Sam extends Thread{
    Exchanger exchanger;
    public Sam(Exchanger exchanger){
        this.exchanger= exchanger;
    }

    @Override
    public void run() {
        try {
           Object value= exchanger.exchange(null);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Object value2=exchanger.exchange(null );
            System.out.println(value2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}