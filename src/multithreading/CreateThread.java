package multithreading;

public class CreateThread {
    public static void main(String[] args) throws InterruptedException {
        Resourse resourse = new Resourse();
        resourse.i=3;
MyThread myThread = new MyThread();
 myThread.setResourse(resourse);

 System.out.println(Thread.currentThread().getName());
 Runnable myRunnable = new MyThread2();
 Thread myThread2 = new Thread(myRunnable);
        myThread.setPriority(10);
        ((MyThread2) myRunnable).setResourse(resourse);
        myThread.start();
        myThread2.start();
myThread2.join();//поки myThread2 не виконається і не завершиться інші потоки не запустяться
 Thread.yield();
 Thread.sleep(1000);
    }
}
class MyThread extends Thread{
    Resourse resourse;

    public void setResourse(Resourse resourse) {
         this.resourse= resourse;
    }

    @Override
    public void run() {
        System.out.println("new thread");
        method();
        resourse.change();
    }
    public void method(){
        System.out.println(Thread.currentThread().getName());
//        throw new RuntimeException();
    }
}
class MyThread2 implements Runnable{
    Resourse resourse;

    public void setResourse(Resourse resourse) {
        this.resourse= resourse;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        resourse.change();

    }
}
class Resourse {
    int i;
  synchronized   void change(){
    synchronized (this){   int i = this.i;
        i++;
        this.i=i;
        System.out.println(this.i);}
    }
}