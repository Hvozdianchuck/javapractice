package lesson1;

public class ExampleInnerclass {
    private int k=3;
    Car car= new Car();
    public static void main(String[] args) throws CloneNotSupportedException {
//        Father father= new Father();
//        father.i=8;
//      Father  father2=father.clone();
//      father2.i=4;
//        System.out.println(father.i);
//        System.out.println(father2.i);
//        System.out.println("--------------");
        Father father1=new Father();
        father1.i=12;
        Son son = new Son();
        son.k=11;
        father1.son=son;
        Father father3=father1.clone();
        father3.i=111;
        father3.son.k=199;
        System.out.println(father1.i);
        System.out.println(father1.son.k);
        System.out.println("--------------");
        ExampleInnerclass exampleInnerclass = new ExampleInnerclass();
        exampleInnerclass.method();
       Car car2= exampleInnerclass.new Car();
        System.out.println(car2.n);
    }
    void method(){

        Car car= new Car();
        System.out.println(car.n);
    }
    class Car{
        private int n=1;
    }}
    class Father implements Cloneable{
    int i=1;
    Son son;
        @Override
        protected Father clone() throws CloneNotSupportedException {
           Father father=  (Father) super.clone();
           father.son=son.clone();
            return father;
        }
    }
    class Son  implements Cloneable{
    int k=3;

        @Override
        protected Son clone() throws CloneNotSupportedException {
            return (Son)super.clone();
        }
    }
