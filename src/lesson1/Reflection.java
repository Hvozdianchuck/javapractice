package lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
  Audi audi = new Audi(50, "red",250,400);
 System.out.println( audi.drive(90) );
 Class c1=audi.getClass();
 Class c2=Audi.class;
 Class c3=Class.forName("lesson1.Audi");
 Audi audi1= (Audi)c1.newInstance();
 Constructor[] constructors= c1.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);

        }            System.out.println("1------------");
      Constructor[]constructors1=c1.getDeclaredConstructors();
        for (Constructor c:constructors1) {
            System.out.println(c);
            c.getParameters();

        }            System.out.println("2------------");
       Field[] fields= c1.getFields();
        for (Field field:fields) {
            System.out.println(field);

        }
        Field[] fields2= c1.getDeclaredFields();
        for (Field field:fields2) {
            System.out.println(field);
            field.setAccessible(true);
            field.setInt(audi,1);
            field.getInt(audi);

        }
        System.out.println("3------------");
        Method[] methods= c1.getMethods();
        for (Method method:methods) {
            System.out.println(method);

        }
        System.out.println("3------------");
        Method[] methods2= c1.getDeclaredMethods();
        for (Method method:methods2) {
            System.out.println(method);

        }
        System.out.println("3------------");
  c1.getModifiers();
  c1.getTypeParameters();

    }

}


class Audi{
    private int price;
    private String color;
    private int maxSpeed;
    private int copacity;

    public Audi() {
    }

    public Audi(int price, String color, int maxSpeed, int copacity) {
        this.price = price;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.copacity = copacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCopacity() {
        return copacity;
    }

    public void setCopacity(int copacity) {
        this.copacity = copacity;
    }
 <T> T drive(T t){

        return t;
 }
}
