package lesson1;

import java.io.Serializable;
import java.util.Comparator;

public class ExampleGeneric<T extends Comparator & Serializable & Comparable > {

    public static void main(String[] args) {

    }
}
//class Car<T> extends ExceptionExample implements Comparable, Serializable {
//int speed;
//String road;
//String drive(String levelroad){
//   if (levelroad.equals("село")){
//       speed = 30;
//   }
//    if (levelroad.equals("місто")){
//        speed = 50;
//    }
//    if (levelroad.equals("траса")){
//        speed = 70;
//    }
//   return "Швидкість "+ speed+" км/год";
//}
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
