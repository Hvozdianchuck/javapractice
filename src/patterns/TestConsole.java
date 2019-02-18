package patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConsole {
    public static void main(String[] args) {
        System.out.println("test console");
        System.out.println(getnumber());
    }
 static Integer getnumber(){
    Map<Integer,Integer> list = new HashMap<>();
    Integer i=list.get(1);
    if (i==null){
        i=2;
        list.put(1,i);
    }

    return i;

}
}
