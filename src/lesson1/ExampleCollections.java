package lesson1;

import java.util.*;

public class ExampleCollections {
    public static void main(String[] args) {
        Queue<String> queue= new LinkedList();
        Deque<String> deque= new LinkedList();
        Deque<String> deque1= new ArrayDeque();
        Queue<String> queue1= new PriorityQueue<>();
        queue.add("one");
        queue.add("tree");
        queue.add("tree");
        for (String s: queue ) {
            System.out.println(s);
        }
        System.out.println("queue------------------");
        deque.add("one");
        deque.add("tree");
        deque.add("tree");
        for (String s: deque ) {
            System.out.println(s);
        }
        System.out.println("queue------------------");
        deque1.add("one");
        deque1.add("tree");
        deque1.add("tree");

        for (String s: deque1 ) {
            System.out.println(s);
        }
        System.out.println("queue------------------");
        queue1.add("one");
        queue1.add("tree");
        queue1.add("tree");
        for (String s: queue1 ) {
            System.out.println(s);
        }
        System.out.println("queue------------------");
        Map hashMap= new HashMap();
        Map linkedHashMap= new LinkedHashMap();
        Map treeMap= new TreeMap();
        hashMap.put("1","Nazar");
        hashMap.put("3","Igor");
        hashMap.put("2","Oleg");
        linkedHashMap.put("1","Nazar");
        linkedHashMap.put("3","Igor");
        linkedHashMap.put("2","Oleg");
        treeMap.put("1","Nazar");
        treeMap.put("3","Igor");
        treeMap.put("2","Oleg");
        Set set=hashMap.entrySet();
        for (Object o:set) {
            System.out.println(o);
        }
        Set set1=linkedHashMap.entrySet();
        for (Object o:set1) {
            System.out.println(o);
        }
        Set set2=treeMap.entrySet();
        for (Object o:set2) {
            System.out.println(o);
        }
        //hashmap Node- hash, next, key, value
//        Collection collection= new ArrayList();
//        Children children= new Children();
//        children.id=1;
//        children.name="Назар";
//        Children children1= new Children();
//        children1.id=1;
//        children1.name="Назар";
//        collection.add(children);
//        collection.add(children1);
        List collection= new ArrayList();
        Children children= new Children();
        children.id=1;
        children.name="Назар";
        Children children1= new Children();
        children1.id=1;
        children1.name="Назар";
        collection.add(children);
        collection.add(children1);
        collection.get(1);
      Iterator iterator= collection.iterator();
      while (iterator.hasNext()){
       Children c=  (Children) iterator.next();
       System.out.println(c.name);
      }
      Worker worker= new Worker();
      worker.name="Oleg";
        Worker worker2= new Worker();
        worker2.name="Igor";
        Set<Worker> set5= new TreeSet(new WorkerComparator());
        set5.add(worker);
        set5.add(worker2);
        for (Worker w  :set5  ) {
            System.out.println(w.name);


        }



    }
}
class Children implements Comparable<Children>{
    int id;
    String name;

    @Override
    public int compareTo(Children children) {
        return this.id-children.id;
    }
}
class Worker{
    int id;
    String name;

    }

    class WorkerComparator implements Comparator<Worker>{

         @Override
        public int compare(Worker o1, Worker o2) {
            return o1.id-o2.id;
        }
    }