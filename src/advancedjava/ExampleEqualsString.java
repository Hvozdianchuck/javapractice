package advancedjava;

import java.text.Collator;

import java.text.MessageFormat;
import java.util.*;

public class ExampleEqualsString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Aw");
        list.add("AA");
        list.add("Mc");
        Collator collator = Collator.getInstance();
        Collections.sort(list, collator);
        collator.setStrength(Collator.PRIMARY);// A=A A=a Germanys letter
        collator.setStrength(Collator.SECONDARY);// A!=A A=a Germanys letter
        collator.setStrength(Collator.TERTIARY);// A!=A A!=a Germanys letter
        for (String s: list){
            System.out.println(s);
        }
        String s= "On 22.02.2017 was huracaine";
        String s2="On 23.02.2017 was sunni";
        String s3="On {0} was {1,date,short}  {2,number, currency} {3,number, percent} {4, choice, 0# no housec| 5#{4}} ";
       String string= MessageFormat.format(s3, "huracane", new GregorianCalendar(2017, 2, 22), 1, 3, 5 );
        System.out.println(string);
        }
        //number integer cuncurrency percent
//date 3 parameter short, medium,long,  full
    //choice


    }

