package lesson1;

public class StringExample{
    public static void main(String[] args) {
        String s= new String("abc");
//    String s2=s.concat("def");
//        System.out.println(s2);
        StringBuffer stringBuffer= new StringBuffer();
        StringBuilder stringBuilder= new StringBuilder(s);
        System.out.println(stringBuilder.append("def"));
    }


}
