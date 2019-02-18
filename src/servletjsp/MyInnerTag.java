package servletjsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyInnerTag extends SimpleTagSupport  {
    @Override
    public void doTag() throws JspException, IOException {
Mytag mytag = (Mytag) findAncestorWithClass(this, Mytag.class);
getJspContext().getOut().print(mytag.getName());
    }
}
