package test;

import java.util.ListResourceBundle;

public class resources_uk extends ListResourceBundle {
    private  static final Object[][] contents =
            {
                    {"readingFile","Привіт"},
                    {"1","Бувай"},
                    {"2","two"}
            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
