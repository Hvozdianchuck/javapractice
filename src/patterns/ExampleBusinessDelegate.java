package patterns;

public class ExampleBusinessDelegate {
    public static void main(String[] args) {
       BusinessDelegate businessDelegate = new BusinessDelegate();
       businessDelegate.doTask("ejb");
        businessDelegate.doTask("jms");
    }
}
interface BusinessService{
    void doJob();
}
class EjbService implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("do ejb job");
    }
}
class JmsService implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("do jms job");
    }
}
class LookupService {
    BusinessService getBusinessService(String nameService){
        if (nameService.equals("ejb")){
            return new EjbService();
        }else return new JmsService();
    }
}
class BusinessDelegate{
    LookupService lookupService = new LookupService();
    BusinessService businessService;
    void doTask(String nameService){
       businessService=lookupService.getBusinessService(nameService);
       businessService.doJob();
    }
}