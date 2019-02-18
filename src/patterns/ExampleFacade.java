package patterns;

public class ExampleFacade {
    public static void main(String[] args) {
        FileFacade fileFacade = new FileFacade();
        fileFacade.enter();
    }
}
class FileFacade{
    String enter(){
        return "enter";
    }
}