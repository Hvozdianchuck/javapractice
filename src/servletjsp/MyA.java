package servletjsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.getWriter().write("a");
     Enumeration<String> enumeration = getServletConfig().getInitParameterNames();
   while(enumeration.hasMoreElements()){
       String s = enumeration.nextElement();
       System.out.println(s+getServletConfig().getInitParameter(s));
       getServletContext().getInitParameter("n");
   }
    }
}
