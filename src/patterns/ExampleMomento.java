package patterns;

public class ExampleMomento {
    public static void main(String[] args) {
Originator originator= new Originator();
originator.setState("one");
CareTaker careTaker = new CareTaker();
careTaker.setMomento(originator.createMomento());
originator.setState("two");
originator.setState("three");
originator.getDataFromMomento(careTaker.getMomento());
System.out.println(originator.getState());
    }
}
class Originator{
 private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Momento createMomento(){
        return new Momento(state);
    }
    public void getDataFromMomento(Momento momento){
        this.state=momento.getState();
    }
}
class Momento{
    private String state;

    public String getState() {
        return state;
    }

public Momento(String state){
        this.state=state;
}
}
class CareTaker{
    Momento momento;
    public void setMomento(Momento momento){
        this.momento=momento;
    }
    public Momento getMomento(){
        return momento;
    }
}