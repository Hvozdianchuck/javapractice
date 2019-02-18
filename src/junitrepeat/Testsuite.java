package junitrepeat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestJunit.class, TestJUnit2.class})
public class Testsuite {
}
