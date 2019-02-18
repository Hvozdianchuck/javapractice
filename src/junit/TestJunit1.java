package junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunit1 {
    String message="Nazar";

    MessageUtil messageUtil = new MessageUtil(message);
    @Test(expected = ArithmeticException.class)
    public void testException(){

    }
    @Test
    public void testPrintMessege(){
        int i=3;
        System.out.println("Inside testPrintMessage()");
        assertFalse(i<1);

       assertEquals(message, messageUtil.printMessage());

       assertNotNull(message);

       }
}
