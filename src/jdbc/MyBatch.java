package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class MyBatch {
    public static void main(String[] args) throws Exception {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);// затримую
            statement.addBatch("DROP TABLE  if EXISTS books");
            statement.addBatch("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
            statement.addBatch("INSERT Into books(name) VALUES ('\"Who Will Cry When You Die\")')");
            statement.addBatch("INSERT Into books(name) VALUES ('\"10xrules\")')");
            if (statement.executeBatch().length == 5){
                connection.commit();
            }else {
                connection.rollback();
            }

        }
    }
}
