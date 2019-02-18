package junitrepeat;

import junit.framework.TestFailure;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Enumeration;

public class TestRunner {
    public static void main(String[] args) {
//      Result result=JUnitCore.runClasses(Testsuite.class);
//        for (Failure failure: result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(result.wasSuccessful());
        TestSuite testSuite= new TestSuite(TestJunit.class,TestJUnit2.class);
        TestResult testResult= new TestResult();

        testSuite.run(testResult);


        System.out.println(testResult.runCount());

   }

}
