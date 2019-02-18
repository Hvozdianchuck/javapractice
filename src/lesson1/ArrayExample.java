package lesson1;

public class ArrayExample {
void method(int a){
    assert (a<0);
    // у командній строці -ea
}
    int a=1;
    {a=2;}
    public static void main(String[] args) {
        // &&, || то не треба заходити в другу частину рівності; ^ - true^true= false,false^false= false,false^true=true якщо різні то true якщо однакові false

        int a2=1;
        System.out.println(++a2);
        System.out.println(a2++);
      int v=(5>6)? 1:3;
        Parent parent= new Parent();
        System.out.println(parent instanceof Child);
        ArrayExample arrayExample=new ArrayExample();
        System.out.println(arrayExample.a);
int[] numberarray= new int[3];
numberarray[0]=1;
numberarray[1]=2;
numberarray[2]=3;
boolean[] boolenarray[]=new boolean[3][];
double doublearray[]={2.3,3.5};
boolean[] m0={true,true,false};
        boolean[] m1={true,true,false};
        boolean[] m2={true,true,false};
boolenarray[0]= m0;
 boolenarray[1]= m1;
 boolenarray[2]= m1;
for (int i=0;i<numberarray.length;i++){
    System.out.println(numberarray[i]);

}
        for (int i=0;i<boolenarray[0].length;i++){
            System.out.println(boolenarray[0][i]+"");
            for (int i1=0;i1<boolenarray[1].length;i1++){
                System.out.println(boolenarray[1][i1]+"");
            }
            for (int i2=0;i2<boolenarray[2].length;i2++){
                System.out.println(boolenarray[2][i2]+"");
            }
        }
        for (int i=0;i<doublearray.length;i++){
            System.out.println(doublearray[i]+"");
        }
        System.out.println("hello world");
    Parent parent2=new Parent();
    Parent child=new Child();
        System.out.println(parent2.method());
        System.out.println(child.method());}
//        strictfp  використовується якщо ми хочемо в методі рахквати з певною точністю

}

class Parent{
    int method(){
        return 3;
    }
}
class Child extends Parent{
    @Override
    int method() {
        return 3+1;
    }
}
