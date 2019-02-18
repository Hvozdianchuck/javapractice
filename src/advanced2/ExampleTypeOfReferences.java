package advanced2;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ExampleTypeOfReferences {
    public static void main(String[] args) {
        String s = new String("one").intern();// кладе поза пул

  Object o = new Object();// strong reference

//        WeakReference<Object> weakReference = new WeakReference<>(o);//weak reference will be remove first garbage collector run
//        SoftReference<Object> softReference = new SoftReference<>(o);//soft reference will be remove when garbage collector run if be few place
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o,referenceQueue);//
        o=null;
        new Thread(){
             @Override
             public void run(){
                 try {
                     referenceQueue.remove();// буде чекати коли garbage collector видалить ссилку
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
         }.start();
        System.out.println("start gc");
        System.gc();
    }
WeakHashMap<String,String> weakHashMap = new WeakHashMap<>();//all object in it will be weak object
}
