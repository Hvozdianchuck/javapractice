package junit;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class JavaJUnit extends TestCase {
    protected int value1, value2;
    protected String namePerson;
@Before
    @Override
    protected void setUp() throws Exception {
        value1=1;
        value2=2;
        namePerson="Nazar";
    }
    @Test(timeout = 10)

      public void testAdd(){
        System.out.println("No of Test Case="+this.countTestCases());
        String name=this.getName();
        System.out.println("Test Case Name="+name);
        this.setName("testNewAdd");
        String newName= this.getName();
        System.out.println("Updated Test Case Name="+newName);

        assertEquals(new MessageUtil("Nazar").printMessage(),namePerson);
      }
    @Override
    protected void tearDown() throws Exception {

    }
}
