package lesson1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WorkwithFile2 {
    public static void main(String[] args) throws IOException {
        File f= new File("temp.txt");
        if (f.exists()){
            System.out.println("new file");
            f.createNewFile();
        }
        if (!f.exists()){
            System.out.println("new file");

        }
        BufferedOutputStream outputStream= new BufferedOutputStream( new FileOutputStream(f));
       byte[] bytes= new byte[]{111,10,50};
        outputStream.write(bytes);
        try(InputStream inputStream1= new FileInputStream(f)){
            byte[] chars3= new byte[inputStream1.available()];
            while (inputStream1.read()!=-1) {
                for (int m2=0; m2<chars3.length; m2++)
                    System.out.println(chars3[m2]);}
        }
        System.out.println("--------------------");
        Path path;
        Files files;
        Path pathFile=Paths.get("temp.txt");

        System.out.println(f.getAbsolutePath());
        System.out.println("------------------");
//        Files.copy(Paths.get("temp.txt"), Paths.get("temp2.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.move(Paths.get("temp2.txt"), Paths.get("temp3.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.delete(Paths.get("temp3.txt"));
//        Files.deleteIfExists(Paths.get("temp3.txt"));
        byte[] bytes2= Files.readAllBytes(Paths.get("temp3.txt"));
        for (int i=0; i<bytes2.length; i++){
            System.out.println(bytes2[i]);
        }
        Files.write(Paths.get("temp3.txt"), "мама".getBytes());
       List<String> list= Files.readAllLines(Paths.get("temp3.txt"));
        for (String s:list) {
            System.out.println(s);
        }
        list.add("test");
        list.add("test2");
        Files.write(Paths.get("temp3.txt"),list);
        Files.walkFileTree(Paths.get("/"), new HashSet<FileVisitOption>(), 1,new MyFolders() );
//     Scanner    PrintWriter
        Scanner scanner= new Scanner(new FileReader("text.txt"));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        PrintWriter printWriter= new PrintWriter(new FileWriter("text.txt"));
        Scanner scanner2= new Scanner(new FileReader("text.txt"));
        PrintWriter print2= new PrintWriter(new FileWriter("text.txt"));

    }
}
class MyFolders extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}