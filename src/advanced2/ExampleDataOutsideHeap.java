package advanced2;

import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExampleDataOutsideHeap {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.get(new byte[]{1,2,3});
        byteBuffer.position();
        byteBuffer.limit();
        byteBuffer.remaining();
        byteBuffer.capacity();
        byteBuffer.flip();
        byteBuffer.position();
        byteBuffer.limit();
        byteBuffer.remaining();
        byteBuffer.capacity();
        byteBuffer.clear();
        FileInputStream fileInputStream = new FileInputStream("test.txt");
       FileChannel fileChannel= fileInputStream.getChannel();
       fileChannel.read(byteBuffer);
      Field field= Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
    Unsafe unsafe=  (Unsafe)field.get(null);
   long startAddress= unsafe.allocateMemory(1024);
   unsafe.putInt(startAddress,5);
        unsafe.putInt(startAddress+4,5);
        unsafe.freeMemory(startAddress);
       Student student= (Student) unsafe.allocateInstance(Student.class);
        System.out.println(student.name);
        System.out.println(student.age);

    }
    static class Student{
        String name;
        int age;
        public Student(){
            this.name="Nazar";
            this.age=20;
        }

    }
}
