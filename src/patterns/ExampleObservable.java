package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleObservable {
    public static void main(String[] args) {
 Observer observer = new Observer(" one ");
 Observer observer2 = new Observer(" two ");
 observer.setState( " new state ");
    }
}
class Observer{
    static List<Observer >observers = new ArrayList<>();
    String name;
    String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
    void notifyAllObservers(){
        for (Observer o: observers) {
            o.update();
        }
    }
    void update(){
        System.out.println(name +"change state"+state);
    }
}