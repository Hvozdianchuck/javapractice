package lesson1;


import java.io.*;

public class ExampleSerialaisble  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student= new SystemIngenerer();
        student.id=1;
        ((SystemIngenerer) student).placeWork="Sombra";
        student.name="Nazar";
        Mark mark =new Mark();
        mark.level=5;
        student.mark=mark;
        FileOutputStream fileOutputStream= new FileOutputStream("test");
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        FileInputStream fileInputStream= new FileInputStream("test");
        ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
       Student student1=(Student)objectInputStream.readObject();
        System.out.println(student1.id);
        System.out.println(student1.name);
        System.out.println(student1.mark);
        System.out.println( ((SystemIngenerer) student).placeWork);
    }
}
//class Student implements Serializable{
//    int id=1;
//    String name;
//  transient   Mark mark;
//}
class Student  {
    int id=1;
    String name;
    transient   Mark mark;
}
class Mark implements Serializable{
    int level;
}
class SystemIngenerer extends Student implements Serializable{
    String placeWork;
}