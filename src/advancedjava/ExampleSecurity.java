package advancedjava;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

public class ExampleSecurity  {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
String s = "hello world";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
        byte[] bytes =  messageDigest.digest(s.getBytes());
        StringBuilder stringBuilder= new StringBuilder();
        for (byte b: bytes) {
          stringBuilder.append(String.format("%02X", b));
        }
        System.out.println(bytes.toString());
        // AES
        String str = "hello";
        Cipher cipher = Cipher.getInstance("AES");
        //random
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
//        SecretKey secretKey = keyGenerator.generateKey();
        //not random
        SecretKeySpec secretKey = new SecretKeySpec("1234vbnmjnasdfgh".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
       byte[] bytes1= cipher.doFinal(str.getBytes());
        for (byte a:bytes1) {
            System.out.println(a);
        }
        Cipher decriptCipher = Cipher.getInstance("AES");
        decriptCipher.init(Cipher.DECRYPT_MODE, secretKey);
         byte[] n = decriptCipher.doFinal(bytes);
        for (byte m:n) {
            System.out.println(m);
        }
        //RSA
        String str2 = "hello";
//        Cipher cipher = Cipher.getInstance("AES");
//
//        SecretKeySpec secretKey = new SecretKeySpec("1234vbnmjnasdfgh".getBytes(), "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        byte[] bytes1= cipher.doFinal(str.getBytes());
//        for (byte a:bytes1) {
//            System.out.println(a);
//        }
//        Cipher decriptCipher = Cipher.getInstance("AES");
//        decriptCipher.init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] n = decriptCipher.doFinal(bytes);
//        for (byte m:n) {
//            System.out.println(m);
//     System.setProperty("java.security.policy", "src/MyApp.policy");
//     System.setSecurityManager(new SecurityManager() );
//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("") } );
//      Class c=  urlClassLoader.loadClass("myClassName");
//      c.getFields();

    }
}
class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes= new byte[0];
        try {
            bytes= Files.readAllBytes(Paths.get("fileName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> сl= defineClass(name,bytes,0, bytes.length);
        return  сl;
    }
}
