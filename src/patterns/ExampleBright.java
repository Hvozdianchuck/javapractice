package patterns;

public class ExampleBright {
    public static void main(String[] args) {
    ICar iCar = new ToyotaCar(new CarBridge());
    iCar.drive();
    }
}
  abstract  class ICar{
    IBridge iBridge;

      public ICar(IBridge iBridge) {
          this.iBridge = iBridge;
      }
      abstract void drive();
  }
     abstract class ITrack{
         IBridge iBridge;

         public ITrack(IBridge iBridge) {
             this.iBridge = iBridge;
         }

         abstract void drive();
     }
     interface IBridge{
    void drive();
     }
     class CarBridge implements IBridge{
         @Override
         public void drive() {

         }
     }
class TrackBridge implements IBridge{
    @Override
    public void drive() {

    }
}
     class ToyotaCar extends ICar{

         public ToyotaCar(IBridge iBridge) {
             super(iBridge);
         }

         @Override
         void drive() {
             System.out.println("Toyota car");
         }
     }
     class AudiCar extends ICar{
         public AudiCar(IBridge iBridge) {
             super(iBridge);
         }

         @Override
         void drive() {
             System.out.println("Audi car");
         }
     }