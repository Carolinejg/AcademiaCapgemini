package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe responsável por fazer conexão com o banco de dados criado 
public abstract class ConnectionFactory {
	private static Connection connection = null;
	public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                              
                String user = "postgres";
                String password = "0715";
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/anunciodb",user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

	}

}
