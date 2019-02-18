package lesson1;

import java.io.*;
import java.util.Properties;

public class ExampleProperties {
    public static void main(String[] args) {
      ExampleProperties exampleProperties = new ExampleProperties();
      exampleProperties.writeProperties(1, "one");
        System.out.println(exampleProperties.readProperties(1));
    }
    void writeProperties(int key, String  value ){
        isFile();
      Properties properties= new Properties();
       properties.setProperty(key+"", value);
      try(FileOutputStream fileOutputStream= new FileOutputStream("word.properties")){
           properties.store(fileOutputStream,"test word");
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
     String readProperties(int key){
        isFile();
        Properties properties= new Properties();

        try(FileInputStream fileInputStream= new FileInputStream("word.properties")){
       properties.load(fileInputStream);
       return  properties.getProperty( key+"");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
  static   void isFile(){
        File file = new File("word.properties");
        if (file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    static class TypesForProperties<K,V>{
//     private K key;
//      private  V value;
//
//        public TypesForProperties(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public void setKey(K key) {
//            this.key = key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V value) {
//            this.value = value;
//        }
//    }
}
