package servletjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/temp")
public class MyThread extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
    }
 }

class Test{

    public static void main(String[] args) throws Exception {
        for (int i = 0; i<100; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/temp").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } }

}