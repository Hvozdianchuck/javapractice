package jmx;

public class Hello implements ExampleJmxMBean {
    private String name;

    @Override
    public void sayHello() {
        System.out.println("say heloo");
    }

    @Override
    public int addIntegers(int a, int b) {
        return a+b;
    }

    @Override
    public Person returnPerson() {
        return new Person();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
    this.name=name;
    }

}
