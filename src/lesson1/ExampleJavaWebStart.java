package lesson1;

import javax.swing.*;
import java.awt.*;

public class ExampleJavaWebStart {
    // we need to include jars from java web start so in console  javac -cp .(and road to java web start jre/lib/javaws.jar ) jre/lib/javaws.jar ExampleJavaWebStart.java
 // then  in console jar cvfe ExampleJavaWebStart.jar ExampleJavaWebStart *.class
    // we need do and put ExampleJavaWebStart.jnlp  file in our folder with .jar. In this file in we write codebase ="and write road to our file" href="ExampleJavaWebStart.jnlp" href change in two places
 // for run  we need create html file and in it write <a href="road to our ExampleJavaWebStart.jnlp"> link</a>
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
        public static void main(String[] args) {
            jFrame.add(jPanel);
            jFrame.add(new JButton("submit"));

    }
    static  JFrame getFrame(){
            JFrame jFrame= new JFrame(){};
            jFrame.setVisible(true);
            jFrame.setBounds(750, 250, 500,500);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return jFrame;
    }
}
