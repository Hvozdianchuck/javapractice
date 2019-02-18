package patterns;

public class ExampleTranferObject {
    public static void main(String[] args) {
        BusinessObject businessObject = new BusinessObject();
        System.out.println(businessObject.getUser().name);
    }
}
class User{

    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class ServiceEjb{
    public User getUser(){
        return new User("Nazar",20);
    }
}
class BusinessObject{
    ServiceEjb serviceEjb = new ServiceEjb();
     User getUser(){
         return serviceEjb.getUser();
     }
    }
