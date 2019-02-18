package patterns;

public class ExampleCompositeEntity {
    public static void main(String[] args) {
CompositeEntity compositeEntity = new CompositeEntity();
        for (String s:compositeEntity.getData()) {
            System.out.println(s);
        }
    }
}
class DependentObject{
    String getDate(){
        return "one";
    }
}
class DependentObject2{
    String getDate(){
        return "two";
    }
}
class CoarseGainedObject{
    DependentObject dependentObject = new DependentObject();
    DependentObject2 dependentObject2 = new DependentObject2();
    public String[] getData(){
        return new String[]{dependentObject.getDate(), dependentObject2.getDate()};
    }

}
class CompositeEntity{
    CoarseGainedObject coarseGainedObject = new CoarseGainedObject();
    public String[] getData(){
        return  coarseGainedObject.getData();
    }
}