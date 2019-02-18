package patterns;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExampleNullObject {
    public static void main(String[] args) {

    }
    static Animal getAnimal(){
        try{
            if (Paths.get("bla").isAbsolute()){
                return new Lion();
            }
        }finally {
            return new NoLion();

        }

    }
}
interface Animal{
    void eat();
}
class Lion implements Animal{
    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }
}
class NoLion implements Animal{

    @Override
    public void eat() {

    }
}