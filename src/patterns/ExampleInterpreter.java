package patterns;

import java.util.Stack;

public class ExampleInterpreter {
    public static void main(String[] args) {
   String expression= "1+2+3";
   Expresion expresion = new Evaluate(expression);
        System.out.println(expresion.interpreter(expresion));
    }
}
interface Expresion{
    int interpreter(Expresion expresion);
}
class Number implements Expresion{
int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public  int interpreter(Expresion expresion) {
        return number;
    }
}
class Plus implements Expresion{
    Expresion expresionLeft;
    Expresion expresionRight;

    public Plus(Expresion expresionLeft, Expresion expresionRight) {
        this.expresionLeft = expresionLeft;
        this.expresionRight = expresionRight;
    }

    @Override
    public int interpreter(Expresion expresion) {
        return expresionLeft.interpreter(expresion)+expresionRight.interpreter(expresion);
    }
}
class Minus extends Plus{
    Expresion expresionLeft;
    Expresion expresionRight;

    public Minus(Expresion expresionLeft, Expresion expresionRight) {
       super(expresionLeft,expresionRight);
    }

    @Override
    public int interpreter(Expresion expresion) {
        return expresionLeft.interpreter(expresion)+expresionRight.interpreter(expresion);
    }
}
class Evaluate implements Expresion{
    Expresion evaluate;
    public Evaluate(String expresion){
        Stack<Expresion> expresions = new Stack<>();
        String expressionRevers = new StringBuilder(expresion).reverse().toString();
        for (String s:expressionRevers.split("\\D")) {
            expresions.push(new Number(Integer.parseInt(s)));
    }
        for (String s:expresion.split("\\d")){
            if (s.equals("+")){
                expresions.push(new Plus(expresions.pop(), expresions.pop()));
            } else if (s.equals("-")){
                expresions.push(new Minus(expresions.pop(), expresions.pop()));

            }
        }
       evaluate= expresions.pop();
               {

        }
    }
    @Override
    public int interpreter(Expresion expresion) {
        return evaluate.interpreter(expresion);
    }
}