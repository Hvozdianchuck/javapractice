package jdbc;

import java.sql.*;

public class MyLevelTransation {
   static String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
  static   String username = "root";
  static   String password = "19980814n";
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            ResultSet resultSet = statement.executeQuery("select count(*) from books");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
            new OtherTransation().start();
            Thread.sleep(3000);
            ResultSet resultSet2 = statement.executeQuery("select count(*)from books");
            while(resultSet2.next()){
                System.out.println(resultSet2.getInt(1));// fantom write
            }

//            Statement statement = connection.createStatement()){
//            connection.setAutoCommit(false);
//            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//            ResultSet resultSet = statement.executeQuery("select * from books");
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//            }
//            new OtherTransation().start();
//            Thread.sleep(3000);     //write
//            ResultSet resultSet2 = statement.executeQuery("select * from books");
//            while(resultSet2.next()){
//                System.out.println(resultSet2.getString("name"));
//            }

//            statement.execute("update books set name = 'new value' where id = 1");
//            new OtherTransation().start();
//            Thread.sleep(2000);
//            connection.rollback();  // dirty read

    }
}
static class OtherTransation extends Thread{
        @Override
    public void run(){
            try(Connection connection2 = DriverManager.getConnection(connectUrl, username, password)  ;
           Statement statement2 = connection2.createStatement()) {
               connection2.setAutoCommit(false);
               connection2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//                ResultSet resultSet = statement2.executeQuery("Select * from Books ");
//                while(resultSet.next()){
//                    System.out.println(resultSet.getString("name"));
//                }    // dirty read
                statement2.executeUpdate("INSERT into books  (name) VALUES ('new value')");
                connection2.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
}
