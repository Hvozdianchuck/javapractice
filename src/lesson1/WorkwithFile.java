package lesson1;

import java.io.*;

public class WorkwithFile {
    public static void main(String[] args) throws IOException {
        Writer writer;
        Reader reader;
        InputStream inputStream;
        OutputStream outputStream;
File filelesson= new File("filelesson.txt");
if (filelesson.exists()){
    filelesson.createNewFile();
}
Writer writer1= new FileWriter(filelesson);
writer1.write("lesoon about work with file");
writer1.flush();
writer1.close();
Reader reader1= new FileReader(filelesson);
//1
 int i=0;
 while ((i=reader1.read())!=-1){
     System.out.println((char) i);
 }
 //2
//        char[] chars2= new char[50];
//        while (reader1.read(chars2)!=-1) {
//            for (int m=0; m<chars2.length; m++)
//                if (Character.isAlphabetic(chars2[m])|| Character.isWhitespace(chars2[m]))
//            System.out.println(chars2[m]);
//        }
        char[] chars2= new char[50];
        while (reader1.read(chars2)!=-1) {
            for (int m=0; m<chars2.length; m++)
                if (Character.isAlphabetic(chars2[m])|| Character.isWhitespace(chars2[m]))
                    System.out.println(chars2[m]);
        }
        System.out.println("--------------------");
        BufferedReader bufferedReader2= new BufferedReader(new FileReader(filelesson));
        while (bufferedReader2.ready()){
            System.out.println(bufferedReader2.readLine());
        }


        System.out.println("--------------------");
File file=new File("test.txt");
if (file.exists()){
    file.createNewFile();
}
        FileWriter fileWriter= new FileWriter(file);

fileWriter.write("lesson1\n");
fileWriter.write("lesson2 bla bla\n");
fileWriter.flush();

char[] chars= new char[40];
        FileReader fileReader= new FileReader(file);
        fileReader.read(chars);
        BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
        bufferedWriter.write("lesson3");
        bufferedWriter.newLine();
        bufferedWriter.write("lesson4");
        bufferedWriter.flush();
        bufferedWriter.close();
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
        System.out.println(chars);
        
    }
}
