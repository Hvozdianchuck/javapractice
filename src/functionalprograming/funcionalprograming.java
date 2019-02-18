package functionalprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class funcionalprograming {
    int met(Mypredacete<Integer> mypredacete){
       if (mypredacete.apply(5)){
           return 2;
       }
       return 3;
    }
    public static void main(String[] args) {
        funcionalprograming funcionalprograming = new funcionalprograming();
        System.out.println(funcionalprograming.met(x -> x==5));
        Predicate<Integer> predicate = x -> x>5;
        Consumer<Integer> costumer = x -> System.out.println(x);
        Function<Integer, String> function = x-> x.toString();
        Supplier<Integer> supplier = () -> new Integer(5);
        UnaryOperator<Integer> unaryoperator = x -> x+5;
        BinaryOperator<Integer> binaryoperator = (x,y) -> x*y;
        Mypredacete<Integer> mypredacete = x -> x==5;

   mypredacete.apply(5);
   List<String> list  = new ArrayList<>();
   list.add("nazar");
   list.add("nazar");
   list.add("nazar");
   list.stream().filter(x-> {
       System.out.println("hello");
       return x.equals("nazar");
   } ).count();
  Set<String> setlist = list.stream().filter(x->x.equals("nazar")).collect(Collectors.toSet());
  list.stream().map(x->x.toUpperCase());
  Stream.of(Arrays.asList("one", "one"), Arrays.asList("one", "one")).flatMap(x-> x.stream());

   Stream <String> stream= list.stream();

   stream.forEach(x -> System.out.println(x));
   stream= list.stream();
   stream.forEach(x-> System.out.println(x));
        stream= list.stream();
        list.stream().forEach(x -> System.out.println(x));
        IntStream intStream = Stream.of(1,2).mapToInt(x->x);
        intStream.summaryStatistics().getAverage();
    }
}

interface Mypredacete<T>{
   boolean  apply(T t);
}

class Strem{

}