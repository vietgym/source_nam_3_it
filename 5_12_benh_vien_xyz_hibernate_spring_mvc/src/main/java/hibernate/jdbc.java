package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/patient_db?allowPublicKeyRetrieval=true";
        String user = "viet";
        String pass = "1234";

        try {
            System.out.println("Connecting to the database: " + jdbcUrl);
            return DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (Exception exc) {
            throw new RuntimeException("Error connecting to the database", exc);
        }
    }
}
