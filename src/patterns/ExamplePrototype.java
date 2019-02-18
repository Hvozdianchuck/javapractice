package patterns;

public class ExamplePrototype {
    public static void main(String[] args) {

    }
}
class MyStudent implements Cloneable{
    @Override
    protected MyStudent clone() throws CloneNotSupportedException {
        return (MyStudent) super.clone();
    }
}
class Cashe{
    private MyStudent myStudent;

    public MyStudent getMyStudent() {
        try {
            return myStudent.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
   return null; }

    public void setMyStudent(MyStudent myStudent) {
        this.myStudent = myStudent;
    }
}