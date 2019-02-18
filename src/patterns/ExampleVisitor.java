package patterns;

public class ExampleVisitor {
    public static void main(String[] args) {
AnimalAction animalAction = new Dog();
 AnimalAction animalAction2 = new Cat();
 animalAction.action(new AnimalVisitor());
 animalAction2.action(new AnimalVisitor());   }
}
interface AnimalAction{
    void action(MyVisitor myVisitor);
}
class Dog implements AnimalAction{
    @Override
    public void action(MyVisitor myVisitor) {
        myVisitor.doDogsJob();
    }
}
class Cat implements AnimalAction{
    @Override
    public void action(MyVisitor myVisitor) {
        myVisitor.doCatsJob();
    }
}
interface MyVisitor{
    void doDogsJob();
    void doCatsJob();
}
class AnimalVisitor implements MyVisitor{
    @Override
    public void doDogsJob() {
        System.out.println("hav");
    }

    @Override
    public void doCatsJob() {
        System.out.println("nyav");

    }
}