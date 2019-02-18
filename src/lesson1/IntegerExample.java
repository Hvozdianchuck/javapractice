package lesson1;

public class IntegerExample {

    public static void main(String[] args) {
        Integer integer=new Integer("1");
       int i= Integer.parseInt("1");
       Integer.toString(1);
        Integer i2= Integer.valueOf("1",2);
//        i++ замість цього
//        int tempvar=i2.intValue();
//        tempvar++;
//        i2=new Integer(tempvar);
       short n= integer.shortValue();
//       System.gc();
     Runtime runtime=Runtime.getRuntime();
    runtime.totalMemory();
    runtime.freeMemory();

    }
}
