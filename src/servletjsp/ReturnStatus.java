package servletjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class ReturnStatus extends HttpServlet {
    @Override()
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//resp.setStatus(HttpServletResponse.SC_OK);
//resp.sendRedirect("/parametr");
//resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//        resp.setHeader("Refresh", "1");
//        System.out.println("hello");
//  resp.setHeader("Refresh", "5;URL=http://google.com");
//  cookies
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());

        }
        Cookie cookie = new Cookie("testCookie", "abc");
        cookie.setMaxAge(5);
        cookie.setPath("/status.html");//куки доступні тільки для цього шляху
        cookie.setDomain("second.mu.localhost");//на моему локалхості можу пропису які хости будуть бачити цей (моі) куки
        cookie.setSecure(true);
        resp.addCookie(cookie);
    }
}
