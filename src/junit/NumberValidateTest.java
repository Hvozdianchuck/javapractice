package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class NumberValidateTest {
    private Integer number;
    private boolean value;
   private NumberValidate numberValidate;
   @Before
public void initialize(){
    numberValidate=new NumberValidate();
}
    public NumberValidateTest(Integer number, boolean value) {
        this.number = number;
        this.value = value;
    }
    @Parameterized.Parameters
    public static Collection testNumbers(){
        return Arrays.asList(new Object[][] {
                { 2, true },
                { 6, false },
                { 19, true },
                { 22, false },
                { 23, true }
        });
            }
            @Test
    public void testNumberValidate(){
                System.out.println("hello"+number);
                Assert.assertEquals(value,numberValidate.validate(number));
            }
        }

