package patterns;

import java.util.HashMap;
import java.util.Map;

public class ExampleFlyWeight {
    public static void main(String[] args) {
        FlyWeightGarage flyWeightGarage = new FlyWeightGarage();
    Mercedes mercedes=flyWeightGarage.getMercedes("green");


        System.out.println(mercedes.color);
    }
}
class Mercedes{
    String color;
}
class FlyWeightGarage {
    Map<String, Mercedes> mercedesMap = new HashMap<>();
    Mercedes getMercedes(String color){
      Mercedes mercedes=  mercedesMap.get(color);

      if (mercedes== null){
          mercedes = new Mercedes();
          mercedes.color=color;
          mercedesMap.put(color, mercedes);
      }
      System.out.println(mercedes.color+"----------");
      return mercedes;
    }
}