package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleMediator {
    public static void main(String[] args) {
 ConcrateMediator conrateMediator = new ConcrateMediator();
 conrateMediator.addColega(new ConctateColega(conrateMediator));
 conrateMediator.addColega(new ConctateColega(conrateMediator));
 ConctateColega conctateColega = new ConctateColega(conrateMediator);
 conctateColega.setChange();
    }
}
interface Mediator{
    void requestAll(Colega colega);
}
class ConcrateMediator implements Mediator{
  List<Colega> list = new ArrayList<>();
  void addColega(Colega colega){
      list.add(colega);
  }
    @Override
    public void requestAll(Colega colega) {
        colega.setTrue();
        for (Colega c: list) {
           if (c!= colega){
               c.setFalse();
           }
        }
    }
}
interface Colega{
    void setFalse();
    void setTrue();
    void setChange();
}
class ConctateColega implements Colega{
    boolean change;
    Mediator mediator;

    public ConctateColega(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setFalse() {
        change=false;
        System.out.println("status false");
    }

    @Override
    public void setTrue() {
   change= true;
        System.out.println("status true");
    }

    @Override
    public void setChange() {
 mediator.requestAll(this);
    }
}