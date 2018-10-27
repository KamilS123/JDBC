package pl.sdacademy.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils {
    private final static JdbcUtils instance = new JdbcUtils();
    private Connection connection;

    public JdbcUtils()  {
        String dbPassword = "winpas";
        String dbUser = "kamil";
        String connectionString = "jdbc:mysql://localhost:3306/uczelnia";

        Properties prop = new Properties();
        prop.put("password",dbPassword);
        prop.put("user",dbUser);

        //Connection connection = DriverManager.getConnection(connectionString,prop);
        String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
        try {
            connection = DriverManager.getConnection(connectionString+connectionOptions, prop);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static JdbcUtils getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}






