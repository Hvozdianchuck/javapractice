package patterns;

public class ExampleFactoryMethod {
    public static void main(String[] args) {
Student student =  Student.createStudent();
student.study();
    }

}
class Student{
    private Student(){}
   public static Student createStudent(){
        return new Student();
    }
    void study(){
        System.out.println("study");
    }
}
