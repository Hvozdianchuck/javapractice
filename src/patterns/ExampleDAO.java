package patterns;

public class ExampleDAO {
    static Data data = new FileSystem();
    public static void main(String[] args) {
        System.out.println(data.getData());
    }
}
interface Data{
    String getData();
}
class FileSystem implements Data{
String getDataFromFs(){
    return "data from fs";
}
    @Override
    public String getData() {
        return getDataFromFs();
    }
}
class DBSystem implements Data{
    String getDataFromFs(){
        return "data from db";
    }
    @Override
    public String getData() {
        return getDataFromFs();
    }
}