package jdbc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class ConnectionDataBase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
 String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
  String username = "root";
String password = "19980814n";
 Class.forName("com.mysql.jdbc.Driver");
 try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
     Statement statement = connection.createStatement()){
//     statement.executeUpdate("DROP TABLE books");
     statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
     BufferedImage bufferedImage = ImageIO.read(new File("image.jpg"));
     Blob blob = connection.createBlob();
try(OutputStream outputStream = blob.setBinaryStream(1)){
     ImageIO.write(bufferedImage,"jpg", outputStream );}
     PreparedStatement statement2 = connection.prepareStatement("insert into books(name, img) values(?,?) " );
statement2.setString(1, "Who Will Cry When You Die");
     statement2.setBlob(1, blob);
     statement2.execute();
     ResultSet resultSet= statement2.executeQuery("select * from Books");
     while(resultSet.next()){
         Blob blob2 = resultSet.getBlob("img");
         BufferedImage image2 = ImageIO.read(blob.getBinaryStream());
         File file = new File("saved.pmg");
         ImageIO.write(image2,"pmg", file );
     }
     //     statement.executeUpdate("insert into Books (name) VALUES('Who Will Cry When You Die')");
//     statement.executeUpdate("insert into Books set name = '10xrules'");
//     ResultSet resultSet = statement.executeQuery("select * from books");
//     while (resultSet.next()){
//         System.out.println(resultSet.getInt(1));
//         System.out.println(resultSet.getString(2));
//         System.out.println("--------------");
//     }
//// String userid = "1' or 1 = '1";
////     ResultSet resultSet2 = statement.executeQuery("select * from Books where id = '" + userid  +"'");
////     while(resultSet2.next()){
////         System.out.println("userName"+ resultSet2.getString("name"));
//
//     String userid = "1";
//     PreparedStatement preparedStatement = connection.prepareStatement("select * from books where id=?");
//     preparedStatement.setString(1, userid);
//     ResultSet resultSet2 = preparedStatement.executeQuery();
//     while(resultSet2.next()){
//         System.out.println("userName"+ resultSet2.getString("name"));
//     }
     }
 }}
