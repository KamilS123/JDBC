package pl.sdacademy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbPassword = "winpas";
        String dbUser = "kamil";
        String connectionString = "jdbc:mysql://localhost:3306/uczelnia";

        Properties prop = new Properties();
        prop.put("password",dbPassword);
        prop.put("user",dbUser);

        //Connection connection = DriverManager.getConnection(connectionString,prop);
        String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
        Connection connection = DriverManager.getConnection(connectionString+connectionOptions, prop);


    }
}