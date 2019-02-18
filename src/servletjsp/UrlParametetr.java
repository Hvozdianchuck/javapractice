package servletjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/parametr")
public class UrlParametetr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String one = req.getParameter("one");
 String two = req.getParameter("two");
 System.out.println(one);
  System.out.println(two);
        Enumeration<String> enumeration = req.getParameterNames();
    while (enumeration.hasMoreElements()){
        System.out.println(enumeration.nextElement());
    }
    Map<String,String[]> map = req.getParameterMap();
        System.out.println(req.getRequestURI());
        System.out.println(req.getServletPath());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getLocalPort());
        System.out.println(req.getQueryString());
        String one2 = req.getParameter("one");
        resp.getWriter().write("<html>+" +
                "<head></head>"+
                "<body>"+
                "one = " + one2 +
                "<form action = 'parametr' method='post'>"+
                "<input type = 'submit' name='submit'/>"+
               "</form>"+
               "</body>"+
                "</html>");

//headers
        Enumeration<String> enumeration2 = req.getHeaderNames();
        while(enumeration2.hasMoreElements()){
            String s = enumeration2.nextElement();
            System.out.println(s + "=" + req.getHeader(s));

        }
        System.out.println(req.getQueryString());
        System.out.println(req.getAuthType());
        System.out.println(req.getContextPath());
        System.out.println(req.getContentLength());
        System.out.println(req.getMethod());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
        System.out.println(req.getProtocol());
        resp.setHeader("Context-Lenght", "100");



    }

    public static void main(String[] args) {

    }
}
