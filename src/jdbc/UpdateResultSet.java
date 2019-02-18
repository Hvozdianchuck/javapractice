package jdbc;

import java.sql.*;

public class UpdateResultSet {
    public static void main(String[] args) throws Exception {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
     statement.executeUpdate("DROP TABLE books");
     statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"Who Will Cry When You Die\")')");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"10xrules\")')");
            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//PreparedStatement preparedStatement = connection.prepareStatement("sql", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            ResultSet resultSet = statement2.executeQuery("SELECT * from books");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            resultSet.last();
            resultSet.updateString("name", "c++");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "java");
            resultSet.insertRow();
            resultSet.absolute(2);
            resultSet.deleteRow();

            resultSet.beforeFirst();
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        }
}}
