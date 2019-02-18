package advanced2;

import jmx.Person;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleImmutable {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
       ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
       long[] deadlockedThreads= threadMXBean.findDeadlockedThreads();
       if (deadlockedThreads!=null){
          ThreadInfo[] threadInfo= threadMXBean.getThreadInfo(deadlockedThreads);
           for (ThreadInfo threadInfo1:threadInfo  ) {
               System.out.println(threadInfo1);
           }
       }
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        List<String> arrayList = Collections.unmodifiableList(list);
        list.add("tree");

        for (String s:arrayList) {
            System.out.println(s);
        }
        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");

        MyImmutable myImmutable = new MyImmutable(1, list2, "test", new Person());


    }
final static class MyImmutable{
        private  final int i;
        private final  List<String> list;
        private final String str;
        private final Person person;

    public MyImmutable(int i, List<String> list, String str, Person person) {
        this.i = i;
        this.list = cloneList(list);
        this.str = str;
        this.person = person.clone();
    }

    private List<String> cloneList(List<String> list) {
        List<String> clone = new ArrayList<>(list.size());
       for (String s:list) {
           clone.add(s);

       }
       return clone;
   }

    public int getI() {
        return i;
    }

    public List<String> getList() {
        return list;
    }

    public String getStr() {
        return str;
    }

    public Person getPerson() {
        return person.clone();
    }


}
    static class Person implements Cloneable{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        protected Person clone()  {
            try {
                return (Person) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
