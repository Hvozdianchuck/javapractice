package patterns;

public class ExampleAbstractFactory {
    public static void main(String[] args) {
 MyAbstractFactory myAbstractFactory = new MyAbstractFactory();
 myAbstractFactory.createFactory("Tank").createMotocycle("T34");
    }
}
interface Motocycle{
    void drive();
}
class Yamaha implements Motocycle{

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}
class Buggati implements Motocycle{

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}
class MotocycleFactory implements MyFactory{
    public Motocycle createMotocycle(String typeCar){
        switch (typeCar){
            case "Yamaha": return new Yamaha();
            case "Buggati": return new Buggati();
            default: return null;
        }
    }

    @Override
    public Tank createTank(String typeCar) {
        return null;
    }
}
interface Tank{
    void drive();
}
class T90 implements Tank{

    @Override
    public void drive() {
        System.out.println("drive T90");
    }
}
class T34 implements Tank{

    @Override
    public void drive() {
        System.out.println("drive T34");
    }
}
class TankFactory implements MyFactory{
    @Override
    public Motocycle createMotocycle(String typeCar) {
        return null;
    }

    public Tank createTank(String typeCar){
        switch (typeCar){
            case "T34": return new T34();
            case "T90": return new T90();
            default: return null;
        }
    }
}
interface MyFactory{
    Motocycle createMotocycle(String typeCar);
    Tank createTank(String typeCar);
}
class MyAbstractFactory{
    public MyFactory createFactory(String typeFactory){
        switch (typeFactory){
            case "Tank": return new TankFactory();
            case "Motocycle": return new MotocycleFactory();
            default: return null;
        }
    }
}