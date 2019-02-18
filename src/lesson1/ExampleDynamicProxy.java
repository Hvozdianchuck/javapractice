package lesson1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class ExampleDynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler= new MyProxy(new Integer(1) );
     Class[] classes = new Class[]{Comparable.class, Callable.class};
       Object o= Proxy.newProxyInstance(null, classes, handler);
        o.getClass();
        System.out.println(((Comparable)o).compareTo(5));
    }
     static  class MyProxy<T> implements InvocationHandler{
        T target;

         public MyProxy(T target) {
             this.target = target;
         }

         @Override
         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             System.out.println(args);
             return method.invoke(target,args);
         }
     }
}
