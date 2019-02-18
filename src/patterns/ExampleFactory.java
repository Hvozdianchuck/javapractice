package patterns;

public class ExampleFactory {
    public static void main(String[] args) {
Factory factory = new Factory();
factory.createCar("Toyota").drive();
        factory.createCar("Audi").drive();
    }
}
interface Car{
    void drive();
}
class Toyota implements Car{

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}
class Audi implements Car{

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}
class Factory{
    public Car createCar(String typeCar){
        switch (typeCar){
            case "Toyota": return new Toyota();
            case "Audi": return new Audi();
            default: return null;
        }
    }
}