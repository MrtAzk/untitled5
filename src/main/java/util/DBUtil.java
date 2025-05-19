package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private DBUtil() {
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/patikaStore";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
