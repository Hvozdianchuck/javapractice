package advancedjava;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ExampleLocale {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        -Duser.language=uk -Duser.region=UK
        Locale locale = new Locale("en","US");
        Locale locale2 = Locale.getDefault();
        Locale locale3 = Locale.GERMAN;
        System.out.println(locale2);
//        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale l:locales) {
//            System.out.println(l);
//        }
        System.out.println(NumberFormat.getCurrencyInstance(locale).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale2).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale3).format(1000));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL,locale).format(new Date()));
        System.out.println("--------------------");
//       ResourceBundle resourceBundle= ResourceBundle.getBundle("resource");
        ResourceBundle resourceBundle2= ResourceBundle.getBundle("resources", new Locale("ru"  ));
    ResourceBundle resourceBundle3= ResourceBundle.getBundle("resources", new Locale("uk"  ));
        System.out.println(new String(resourceBundle2.getString("1").getBytes("ISO-8859-1"),"UTF-8"));
        System.out.println(resourceBundle2.getString("1"));
        ResourceBundle resourceBundleclas= ResourceBundle.getBundle("test.resources_uk", new Locale("uk"  ));
        System.out.println(resourceBundleclas.getString("readingFile"));
    }}
