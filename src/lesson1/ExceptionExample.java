package lesson1;

public class ExceptionExample {
    String method(){
        try{
            System.out.println("try");
            Object o=null;
            o.hashCode();
            System.out.println("try2");
        }        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("catch");
        }
        catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("catch");
        }

        finally{
            System.out.println("finally");
            return "finnally2";
        }

    }
    public static void main(String[] args) {
//        System.out.println(new ExceptionExample().method());
        try{
            System.out.println("try");
            Object o=null;
            o.hashCode();
            System.out.println("try2");
            //            System.exit(0); - не виконується
//            while (true){}  - не виконується
// throw new Error();- виконується
// throw new RuntimeException(); - виконується

        }

        finally{
//            System.exit(0);
// throw new Error();
// throw new RuntimeException();
            System.out.println("finally");
//            while (true){}
        }
   }
}
