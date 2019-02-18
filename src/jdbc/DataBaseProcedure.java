package jdbc;

import com.mysql.jdbc.CallableStatement;

import java.sql.*;

public class DataBaseProcedure {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
//     statement.executeUpdate("DROP TABLE books");
            statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
        CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call BooksCout(?) }");
callableStatement.registerOutParameter(1, Types.INTEGER);
callableStatement.execute();
System.out.println(callableStatement.getInt(1));
            System.out.println("-----------------");
            CallableStatement callableStatement2 = (CallableStatement) connection.prepareCall("{call getBooks(?)}");
       callableStatement2.setInt(1, 1);
      if(callableStatement2.execute()){
ResultSet resultSet = callableStatement2.getResultSet();
while(resultSet.next()){
    System.out.println(resultSet.getInt("id"));
    System.out.println(resultSet.getString("name"));
}
            }
        }
    }
}