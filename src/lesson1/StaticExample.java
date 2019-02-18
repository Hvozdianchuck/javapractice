package lesson1;

public class StaticExample {
    static StaticExample staticExample=new StaticExample();
    static int a;
    int i;
    {i=1;}

    static {a++;}
    public StaticExample(){
        i++;
        a++;
        System.out.println("construstor "+i+" "+a+"");
    }
    public static void main(String[] args) {
new StaticExample();
    }
}
