package jdbc;

import java.sql.*;

public class MyMetaData  {
    public static void main(String[] args) throws Exception {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){

            statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"Who Will Cry When You Die\")')");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"10xrules\")')");
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));//this need
                System.out.println(resultSet.getString(4));

            }
            ResultSet resultSet2 = statement.executeQuery("select * from books");
            ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
            for (int i = 1; i<= resultSetMetaData.getColumnCount(); i++){
                System.out.println(resultSetMetaData.getColumnLabel(i));
            }
        }
    }
}
