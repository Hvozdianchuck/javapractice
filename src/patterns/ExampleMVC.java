package patterns;

public class ExampleMVC {
    public static void main(String[] args) {
Controller controller = new Controller();
controller.execute();
    }
}
class MyTeacher{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface Model{
    MyTeacher getMyTeacher();
}
class ConsoleModel implements Model{

    @Override
    public MyTeacher getMyTeacher() {
        MyTeacher myTeacher = new MyTeacher();
        myTeacher.setName("Olexandra");
        return myTeacher;
    }
}
class Controller{
    Model model = new ConsoleModel();
    View view = new ConsoleView();
    void execute(){
        MyTeacher myTeacher = model.getMyTeacher();
        view.showMyTeacher(myTeacher);
    }
}
interface View{
    void showMyTeacher(MyTeacher myTeacher);
}
class ConsoleView implements View{

    @Override
    public void showMyTeacher(MyTeacher myTeacher) {
        System.out.println(myTeacher.getName());
    }
}