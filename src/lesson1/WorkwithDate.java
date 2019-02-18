package lesson1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkwithDate {

    public static void main(String[] args) throws ParseException {
        Date date= new Date();
        System.out.println(date);
        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.getTime());
       calendar.add(Calendar.DAY_OF_WEEK,1);
        System.out.println(calendar.getTime());
        DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat.format(calendar.getTime()));
        Test test= new Test() {
            @Override
            void method() {

            }
        };
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
      Date date2=simpleDateFormat.parse("08/12/2018");
        System.out.println(date2);
    }

}
abstract class Test{
    String value1;
    int value2;
    Test(){
        System.out.println("constructor");
        this.value1="Nazar";
        this.value2=1;
    }
   abstract void method();
    void method2(){
        System.out.println("method2");
    }
}