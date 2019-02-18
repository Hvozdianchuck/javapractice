package patterns;

public class ExampleChainOfResponsibility {
    public static void main(String[] args) {
MessagePrinter messagePrinter = new ConsoleMessagePrinter();
FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
messagePrinter.setNexMessagePrinter(fileMessagePrinter);
fileMessagePrinter.setNexMessagePrinter(new DBMessagePrinter());
messagePrinter.print(" print");
    }
}
abstract class MessagePrinter {
    MessagePrinter nexMessagePrinter;

    public void setNexMessagePrinter(MessagePrinter nexMessagePrinter) {
        this.nexMessagePrinter = nexMessagePrinter;
    }
    void print(String massage){
        this.printMessage(massage);
        if (nexMessagePrinter!=null){
            nexMessagePrinter.print(massage);
        }
    }
    abstract void printMessage(String message);
}
class ConsoleMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to console"+message );
    }
}
class FileMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to file"+message );
    }
}
class DBMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to database"+message );
    }
}