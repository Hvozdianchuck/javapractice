package jdbc;

import java.sql.*;

public class DataBasemoreresult {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
     statement.executeUpdate("DROP TABLE books");
            statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");

            CallableStatement callableStatement = connection.prepareCall("{call getCout() }");
            boolean hasResuls = callableStatement.execute();
            while(hasResuls){
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                }
                System.out.println("------");
                hasResuls = callableStatement.getMoreResults();
            }

//          Scrollable RowSet
            Statement statement3 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from books");
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            if (resultSet.previous())
                System.out.println(resultSet.getString("name"));
            if (resultSet.relative(2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.relative(-2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.absolute(2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.first())
                System.out.println(resultSet.getString("name"));
            if (resultSet.last())
                System.out.println(resultSet.getString("name"));
               resultSet.beforeFirst();
               resultSet.next();



        }
    }
}
