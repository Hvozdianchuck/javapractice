package patterns;

public class ExampleAdapter {
    public static void main(String[] args) {
        CarWash carWash= new CarWash();
        carWash.washCar(new TrackWash(new MyTrack()));

    }
}
class TrackWash implements MyCar2{
Track track;

    public TrackWash(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}
interface Track{
    void clean();
}
class MyTrack implements  Track{

    @Override
    public void clean() {

    }
}
interface MyCar2{
    void wash();
}
class Audi2 implements MyCar2{

    @Override
    public void wash() {

    }
}
class CarWash{
    public void washCar(MyCar2 car){
        car.wash();
    }
}