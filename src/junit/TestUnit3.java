package junit;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestUnit3 extends TestResult {
    @Override
    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
    }

    @Override
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure(test, t);
    }
    @Ignore
@org.junit.Test
public void  testAdd(){

assertEquals(new MessageUtil("Oleg").printMessage(),"Nazar");}
    @Override
    public synchronized void stop() {
        super.stop();
    }

}
