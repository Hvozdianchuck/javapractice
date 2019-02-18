package jdbc;

import java.sql.*;

public class DataBaseData {
    public static void main(String[] args) throws Exception {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){

            statement.executeUpdate("CREATE table  Books2 (id mediumint NOT NULL AUTO_INCREMENT, name CHAR(30) NOT null, dt DATA , PRIMARY KEY (id)  )");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into books2(name, dt) values ('somename',?)");
            preparedStatement.setDate(1, new Date(1486512000021L));
            preparedStatement.execute();
            System.out.println(preparedStatement);
            statement.executeUpdate("insert info Books(name, dt) Value('someName', {d'2017-02-08'}) ") ;
         ResultSet resultSet = statement.executeQuery("select* from books2");
         while(resultSet.next()){
             System.out.println(resultSet.getDate("dt"));
         }

        }
}
}
