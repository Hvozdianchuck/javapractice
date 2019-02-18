package junitrepeat;

import junit.framework.TestCase;
import org.junit.Test;

public class TestJUnit2 extends TestCase {
    private int value1,value2;
    @Override
    protected void setUp() throws Exception {
        value1=1;
        value2=2;
    }
    @Test
public void testmethod(){

}
    @Override
    protected void tearDown() throws Exception {

    }
}
