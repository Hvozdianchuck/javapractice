package servletjsp;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
        System.out.println(filterConfig.getInitParameter("name"));

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
filterChain.doFilter(servletRequest, new MyProxy((MyProxy)servletResponse));//will work servlet

    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");


    }
}

class MyProxy extends HttpServletResponseWrapper{
    public MyProxy(HttpServletResponse response) {
        super(response);
    }
    @Override
    public PrintWriter getWriter() throws IOException{
        return super.getWriter();
    }
}