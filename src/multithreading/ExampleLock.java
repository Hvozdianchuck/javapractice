package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleLock {
    public static void main(String[] args) {
ResourseLock resourseLock = new ResourseLock();
MyThread myThread = new MyThread();
myThread.resourseLock= resourseLock;
myThread.start();
    }
    static class MyThread extends Thread{
        ResourseLock resourseLock;
        @Override
        public void run() {
            resourseLock.change1();
            resourseLock.change2();
        }
    }
}
class ResourseLock {
    int i;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
        void change1(){
            lock.lock();
    int i = this.i;
            i++;
            this.i=i;
            System.out.println(this.i);}
        int change2(){
        int i = this.i;
        i++;
        this.i=i;
        System.out.println(this.i);
            lock.unlock();
            return this.i;}
            void example(){
            if (lock.tryLock()){
                System.out.println("try lock");
            }
            }
    int change3() throws InterruptedException {
            lock.lock();
            condition.await();
        int i = this.i;
        i++;
        this.i=i;
        System.out.println(this.i);
lock.unlock();
        return this.i;
        }
    void example2(){
            lock.lock();
    condition.signal();
    lock.unlock();
            System.out.println("try lock");

    }
    }
