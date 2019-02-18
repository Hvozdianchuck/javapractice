package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleFilter {
    public static void main(String[] args) {

    }
}
class MyCar{
    private int doors;
    private int speed;

    public MyCar() {
    }

    public MyCar(int doors, int speed) {
        this.doors = doors;
        this.speed = speed;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
interface Filter{
    List<MyCar> filter(List<MyCar> list);
}
class SpeedFilter implements Filter{
    @Override
    public List<MyCar> filter(List<MyCar> list) {
        List<MyCar> list1 = new ArrayList<>();
        for (MyCar myCar:list) {
            if (myCar.getSpeed()>150){
                list1.add(myCar);
            }
        }
        return list1;
    }
}
class DoorsFilter implements Filter{
    @Override
    public List<MyCar> filter(List<MyCar> list) {
        List<MyCar> list1 = new ArrayList<>();
        for (MyCar myCar:list) {
            if (myCar.getDoors()>2){
                list1.add(myCar);
            }
        }
        return list1;
    }
}
class AndFilter implements Filter{
    Filter filterOne;
    Filter filterTwo;

    public AndFilter(Filter filterOne, Filter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<MyCar> filter(List<MyCar> list) {
List<MyCar> list1 = filterOne.filter(list);

        return  filterTwo.filter(list1);
    }
}
class OrFilter implements Filter{
    Filter filterOne;
    Filter filterTwo;

    public OrFilter(Filter filterOne, Filter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<MyCar> filter(List<MyCar> list) {
        List<MyCar> list1 = filterOne.filter(list);
        List<MyCar> list2 =   filterTwo.filter(list1);
        for (MyCar myCar: list2) {
            if (!list1.contains(myCar)){
                list1.add(myCar);
            }
        }
        return list1;
    }
}