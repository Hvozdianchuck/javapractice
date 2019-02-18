package patterns;

public class ExampleDecorator {
    public static void main(String[] args) {
FileStream fileStream = new FileBufferedReader(new FileStreamReader());
fileStream.read();

    }
}
interface FileStream{
    void read();
}
class FileStreamReader implements FileStream{

    @Override
    public void read() {
        System.out.println("file read");
    }
}
abstract  class FileDecorator implements FileStream{
    FileStream fileStream;
    public FileDecorator(FileStream fileStream) {
        this.fileStream = fileStream;
    }
    public abstract void read();

}
class FileBufferedReader extends FileDecorator{
    public FileBufferedReader(FileStream fileStream) {
        super(fileStream);
    }

    @Override
    public void read() {
        fileStream.read();
        System.out.println("buffered read");
    }
}