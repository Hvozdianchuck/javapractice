package patterns;

public class ExampleStrategy {
    public static void main(String[] args) {
 double startPrice = 100;
 Context context = new Context(new HalfPrice());
        System.out.println(context.getPrice(startPrice));
    }
}
interface Strategy{
    double getPrice(double price);
}
class FullPrice implements Strategy{

    @Override
    public double getPrice(double price) {
        return price;
    }
}
class HalfPrice implements Strategy{

    @Override
    public double getPrice(double price) {
        return price*0.5;
    }
}
class Context{
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public  double getPrice(double price){
        return strategy.getPrice(price);
    }
}