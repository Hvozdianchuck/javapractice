package patterns;

import java.util.Scanner;

public class ExampleFrontController {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);) {

            while (scanner.hasNext()){
                new DispatcherServlet().process(scanner.nextLine());
            }
        }
    }
}
class DispatcherServlet{
   void process(String controller){
       switch (controller){
           case "home": new HomeController().show(); break;
           case "user": new UserController().show();  break;
           case "error": new ErrorController().show();  break;
           default:
       }
   }
}
class HomeController{
    void show(){
        System.out.println("it is home page");
    }
}
class UserController{
    void show(){
        System.out.println("it is user page");
    }
}
class ErrorController{
    void show(){
        System.out.println("it is error page");
    }
}