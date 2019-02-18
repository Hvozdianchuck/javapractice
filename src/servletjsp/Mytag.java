package servletjsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class Mytag extends SimpleTagSupport {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
     JspWriter out = getJspContext().getOut();
        getJspContext().setAttribute("one","two");
     out.print("hello world<br/>");
     out.print(name+ "<br/>");
     out.print("<b>");
     getJspBody().invoke(null);
     out.print("</b>");

     StringWriter stringWriter = new StringWriter();
     getJspBody().invoke(stringWriter);
     out.print("<b>");
     out.print(stringWriter.toString());
     out.print("</b>");
}}
