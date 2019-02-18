package patterns;

public class ExampleIterator {
    public static void main(String[] args) {
Container container = new ArrayContainer();
Iterator iterator=container.getIterator();
while (iterator.hasNext()){
    System.out.println(iterator.next());
}
    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}
interface  Container{
    Iterator getIterator();
}
class ArrayContainer implements Container{
    String[] array =  {"Nazar", "Oleg", "Igor"};
    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }
    class ArrayIterator implements Iterator{
int index;
        @Override
        public boolean hasNext() {
            return (index<array.length)?true: false;
        }

        @Override
        public Object next() {

            if (hasNext()){return array[index++];}
            return false;
        }
    }
}
