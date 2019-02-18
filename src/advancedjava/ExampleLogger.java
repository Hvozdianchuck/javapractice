//package advancedjava;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.logging.*;
//
//public class ExampleLogger {
//    private  static  final Logger logger = Logger.getLogger(ExampleLogger.class.getName());
//    private  static  final Logger logger2 = Logger.getLogger(ExampleLogger.class.getName());
//    public static void main(String[] args) throws IOException {
//        Thread.dumpStack();
//        PrintWriter writer = new PrintWriter(new File("test.log"));
//        new Throwable().printStackTrace();
//        writer.flush();
//        writer.close();
////        Thread.setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler(){
////
////        }
//
//// sonarqube
//        //visualvm
////        if which jar not include in console write java -verbose nameclass.class
////        -Djava.util.logging.config.file=C:\Users\Назар\IdeaProjects\javapractice\src\advancedjava\log.properties
////        LogManager.getLogManager().readConfiguration();
////        System.out.println(System.getProperty("java.util.logging.config.file"));
////        logger.info("me  ssage");
//        //levels
////          SEVERS
////          WARNING
////          INFO
////          CONFIG
////          FINE
////          FINER
////          FINEST
//       logger.log(Level.FINER, "finer");
//        logger.log(Level.INFO, "info");
//        logger.log(Level.WARNING, "warning", new Throwable());
//        Handler handler = new ConsoleHandler();//
//     FileHandler fileHandler=   new FileHandler("%h/myJavaLog.log");//%h- in home directory %t- in temp %a-unique number to resolve conflicts %q %%
//
//        handler.setFilter(new MyFilter());
//        handler.setFormatter(new MyFormatter());
//     logger2.setUseParentHandlers(false);
//     logger2.addHandler(handler);
//     logger2.info("info Nazar");
//
////        new StreamHandler();
////        new SocketHandler();
//
//    }
////    static class MyFilter implements patterns.Filter {
////
////        @Override
////        public boolean isLoggable(LogRecord record) {
////            return record.getMessage().endsWith("Nazar");
////        }
////    }
////    static class MyFormatter extends Formatter {
////        @Override
////        public String format(LogRecord record) {
////            return record.getLevel()+ record.getMessage();
////        }
////    }
////}
