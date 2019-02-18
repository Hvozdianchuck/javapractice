package lesson1;

import javax.swing.*;

public class ExampleApplet extends JApplet {
    // html pages <applet code="ExampleApplet" width="300" height="300"></applet> or <objectccodetype="application/java" classid="java.ExampleApplet.class" width="300" height="300"></object>
// for run we cannot use browsers(they lock applets) so we use (in console) appletviewer test.html(name html file which we need)
 // <param name="buttonName" value="Submit"/> so we can change parameters in java code from html code
    @Override
    public void init() {
        add(new JButton(getParameter("buttonName")));
    }
}
