package functionalprograming;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Colectm {


    public static void main(String[] args)  {
        Stream.of("one","two").collect(toCollection(TreeSet::new));
        Stream.of("one","two").collect(maxBy(Comparator.comparing(x->x)));
        Stream.of(1,2).collect(averagingInt(x->x));
        Map<Boolean, List<Integer>> map = Stream.of(1,2,3,4).collect(partitioningBy(x->x>2));
        Map<Integer, List<Integer>> map2 = Stream.of(1,2,3,4).collect(groupingBy(x->x));
        String rezult = Stream.of("one","two","tree").collect(joining(",","{","}"));
        Map<Integer, Long> map3 = Stream.of(1,2,1,4).collect(groupingBy(x->x,counting()));
        Stream stream = Stream.of(1,2).parallel();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< 1000_000; i++){
        list.add(i);
        list.add(10_000_000-i);
 Colectm[] colectms = (Colectm[]) stream.toArray(Colectm[]::new);



    }
    System.out.println(new Date());
        list.parallelStream().sorted().count();
        System.out.println(new Date());
    }}
//    class TestOptional{
//    public Optional<List<Integer>> method(Integer value){
//        return Optional<>
//    }
//    }
