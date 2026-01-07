package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionPostgreSql {
    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL Driver Loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL Driver not found", e);
        }
    }

    private static final String URL =
            "jdbc:postgresql://localhost:5432/CRUD_OPERATIONS_DB";

    private static final String USER = "postgres";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
