package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class MyTransactions {
    public static void main(String[] args) throws Exception{
        String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
        String username = "root";
        String password = "19980814n";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);// затримую
            statement.execute("DROP TABLE  if EXISTS books");
            statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
            statement.executeUpdate("INSERT Into books(name) VALUES ('Who Will Cry When You Die')");
            Savepoint savepoint = connection.setSavepoint();//точка зупинки усе що до неі виконаеться а після ролбекниться
            statement.executeUpdate("INSERT Into books(name) VALUES ('10xrules')");
//           connection.commit();//пускаю
//            connection.rollback();// операціі з базою не  подіють не усі. Подіють  ті які змінюють зінні INSERT update, DROP, CREATE, delete(не завжди) не зупинить
connection.rollback(savepoint);
connection.commit();
connection.releaseSavepoint(savepoint);// не обовязково
        }
}}

