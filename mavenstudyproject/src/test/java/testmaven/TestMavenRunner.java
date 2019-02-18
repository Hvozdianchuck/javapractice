package testmaven;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import testmaven.TestMaven;

public class  TestMavenRunner {
    public static void main(String[] args) {
       Result result= JUnitCore.runClasses(TestMaven.class);
        for (Failure  failure:result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
