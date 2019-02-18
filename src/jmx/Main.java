package jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer= ManagementFactory.getPlatformMBeanServer();
        ObjectName name= new ObjectName("jmx:type=ExampleJmx");
        Hello hello = new Hello();
        mBeanServer.registerMBean(hello,name);
        System.out.println("Waiting ");
        Thread.sleep(Long.MAX_VALUE);
    }
}
