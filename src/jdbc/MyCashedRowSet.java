package jdbc;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
public class MyCashedRowSet {
    static String connectUrl = "jdbc:mysql://localhost:3306/Lessons?useSSL=false";
  static   String username = "root";
 static    String password = "19980814n";

    public static void main(String[] args) throws Exception {
        ResultSet resultSet5 = get();
        CachedRowSet cachedRowSet = (CachedRowSet) resultSet5;
        cachedRowSet.setUrl(connectUrl);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);
        while (resultSet5.next()){
            System.out.println(resultSet5.getString("name"));
        }


        cachedRowSet.setCommand("select * from Books where name =?");
        cachedRowSet.setInt(1,1);
        cachedRowSet.setPageSize(20);
        cachedRowSet.execute();
        do {
            while (cachedRowSet.next()){
            System.out.println(cachedRowSet.getString("name"));
            }
        }while (cachedRowSet.nextPage());
        CachedRowSet cachedRowSet3 =(CachedRowSet) resultSet5;
        cachedRowSet3.setTableName("Books");
        cachedRowSet3.absolute(1);
        cachedRowSet3.deleteRow();
        cachedRowSet3.beforeFirst();
        while(cachedRowSet3.next()){
            System.out.println(cachedRowSet3.getString("name"));
        }
        cachedRowSet3.acceptChanges(DriverManager.getConnection(connectUrl, username, password));
// or        cachedRowSet.setUrl(connectUrl);
//        cachedRowSet.setUsername(username);
//        cachedRowSet.setPassword(password);
    }
    static ResultSet get() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectUrl, username, password);
            Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP TABLE books");
            statement.executeUpdate("CREATE table IF NOT EXISTS Books (id mediumint NOT NULL AUTO_INCREMENT,img Blob, name CHAR(30) NOT null, PRIMARY KEY (id)  )");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"Who Will Cry When You Die\")')");
            statement.executeUpdate("INSERT Into books(name) VALUES ('\"10xrules\")')");
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();
            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement2.executeQuery("SELECT * from books");
            cachedRowSet.populate(resultSet);
            return resultSet;

    }
}
}
