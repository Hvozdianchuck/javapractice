package multithreading;

import java.util.concurrent.Phaser;

public class ExamplePhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser).start();
        new Washer(phaser).start();


    }
    static class Washer extends Thread{
        Phaser phaser;
        public Washer(Phaser phaser){
            this.phaser=phaser;
        }

        @Override
        public void run() {
            for (int i=0;i<3;i++){
                System.out.println(getName()+"washing car");
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}

