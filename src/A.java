public class A{
    public static void main(String[] args) {
        C.method2();
    }
    public static interface C{
     static   public final int i= 2 ;
            public  void method();
            static void method2(){}
    }
}
    interface C2{
    static   public final int i= 2 ;
}