package patterns;

public class ExampleState {
    public static void main(String[] args) {
        MyContext myContext = new MyContext(new MyUpperCase(),"one");
        MyContext myContext2 = new MyContext(new MyLoverCase(),"one");
        myContext.doAction();
        myContext2.doAction();

    }
}
interface State{
    void doAction(MyContext context);
}
class MyLoverCase implements State{
    @Override
    public void doAction(MyContext context) {
        System.out.println(context.name.toLowerCase());
    }

}
class MyUpperCase implements State{
    @Override
    public void doAction(MyContext context) {
        System.out.println(context.name.toUpperCase());
    }

}
class MyContext{
    State state;
    String name;

    public MyContext(State state, String name) {
        this.state = state;
        this.name = name;
    }
    void doAction(){
        state.doAction(this);
    }
}