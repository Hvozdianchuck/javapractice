package advancedjava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ExamplePreferences {
    public static void main(String[] args) throws IOException, BackingStoreException {
//        Preferences rootPreferences =  Preferences.systemRoot();
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.put("key", "value");
        System.out.println(userPreferences.get("key", "default value"));
        Preferences node = userPreferences.node("mypackage");
        node.put("one","1");
        System.out.println(node.getInt("one",2));
        Preferences myPackage = Preferences.userNodeForPackage(Preferences.class);
        userPreferences.exportSubtree(new FileOutputStream("myProperties.xml"));



    }
}
