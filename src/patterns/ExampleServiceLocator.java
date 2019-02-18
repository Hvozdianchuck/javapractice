package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleServiceLocator {
    public static void main(String[] args) {
Service service = ServiceLocator.getService("Service1");
service.execute();
service= ServiceLocator.getService("Service2");
service.execute();
    }
}
interface Service{
    void execute();
    String getName();
}
class Service1 implements Service{

    @Override
    public void execute() {
        System.out.println("Executing service1");
    }

    @Override
    public String getName() {
        return "service1";
    }
}
class Service2 implements Service{
    @Override
    public void execute() {
        System.out.println("Executing service2");
    }

    @Override
    public String getName() {
        return "service2";
    }
}
 class InitialContext {
    public Object lookup(String jndiName){
        if (jndiName.equalsIgnoreCase("SERVICE1")){
            return new Service1();
        }else if (jndiName.equalsIgnoreCase("SERVICE@")){
            return new Service2();
        }
        return  null;
    }
 }
 class MyCashe{
    private List<Service> list = new ArrayList<>();
    public Service getService(String serviceName){
        for (Service service:list) {
            if (service.getName().equalsIgnoreCase(serviceName)){
            System.out.println("returning cashe "+serviceName);
        return service;
            }
         }
   return null; }
    public  void addService(Service newService){
        boolean exists = false;
        for (Service s: list) {
            if (s.getName().equalsIgnoreCase(newService.getName())){
                exists = true;
            }
        }
        if (!exists){
            list.add(newService);
        }
    }
 }
 class ServiceLocator{
    private  static MyCashe myCashe;
    static {
        myCashe = new MyCashe();
    }
    public static Service getService(String jndiName){
        Service service = myCashe.getService(jndiName);
        if (service!= null){
            return service;
        }
        InitialContext initialContext = new InitialContext();
        Service service1 =  (Service1)initialContext.lookup(jndiName);
        myCashe.addService(service1);
        return service1;
    }
 }