package servletjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/mysesia", asyncSupported = true)
public class MySesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Enumeration<String> enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()){
            String atribete = enumeration.nextElement();
            System.out.println(atribete + "+" + session.getAttribute(atribete));
        }
        session.setAttribute("one", "two");
        System.out.println(session.getMaxInactiveInterval());
session.setMaxInactiveInterval(1); }
//    asynsSupported

//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        AsyncContext asyncContext = req.getAsyncContext();
//        asyncContext.start(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//    asyncContext.complete();
//    }
}
