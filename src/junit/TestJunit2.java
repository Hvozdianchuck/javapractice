package junit;

import com.mysql.fabric.Server;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestJunit2 implements TestRule{
    String message="Oleg";

@Rule
public final TemporaryFolder folder= new TemporaryFolder();
@Rule
public final ErrorCollector errorCollector= new ErrorCollector();
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    MessageUtil messageUtil = new MessageUtil(message);
    @Rule
    public final ExternalResource resource = new ExternalResource(){
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void before() throws Throwable {
            super.before();
        }

        @Override
        protected void after() {
            super.after();
        }
    };
    @Rule
    public final Verifier verifier = new Verifier(){
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void verify() throws Throwable {
            super.verify();
        }
    };
    @Rule
    public final TestRule watchman = new TestWatcher(){
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };
    @Rule
    public final TestName name = new TestName();
    @Rule
    public final Timeout timeout= new Timeout(1000);
    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    @ClassRule
    public static final ExternalResource resource2 = new ExternalResource() {
        @Override
        protected void before() throws Throwable {

        };

        @Override
        protected void after() {

        };
    };
//    @Rule
//    public final TestRule chain = RuleChain
//            .outerRule())
//            .around())
//            .around());
    @Ignore
    @Test
    public void testPrintMessege() throws IOException {
        System.out.println("Inside testPrintMessage()");
        File file=folder.newFile("test.txt");
        folder.newFolder("testFolder");

        assertEquals(message, messageUtil.printMessage());
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

            }
        };
    }
}