package testmaven;

import org.junit.*;
import testmavenclass.StudyMaven;

import static org.junit.Assert.*;
public class TestMaven {
    @Test
    public void testMaven(){
        StudyMaven studyMaven= new StudyMaven();
         Assert.assertEquals(studyMaven.method(),3);
    }

}
