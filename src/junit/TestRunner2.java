package junit;

import junit.framework.TestResult;
import junit.framework.TestSuite;

import javax.xml.transform.Result;

public class TestRunner2{
    public static void main(String[] args) {
        TestSuite suite= new TestSuite(JavaJUnit.class,TestJunit2.class, TestUnit3.class);
        TestResult result= new TestResult();

        suite.run(result);
        System.out.println("Number of test cases="+result.runCount());

        System.out.println(result.wasSuccessful());
    }
}
