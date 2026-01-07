package CrudOperations;
import java.sql.*;

public class UserService {

public void addUser(UserEntity user) throws SQLException {

    String sql =
            "INSERT INTO users (name, email, contact_number) VALUES (?, ?, ?)";

    try (Connection conn = DBConnectionPostgreSql.getConnection();
         PreparedStatement pstmt =
                 conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getContactNumber());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            System.out.println("User added with ID: " + generatedId);
        }
    }
}



    public void getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users";

        try (Connection conn = DBConnectionPostgreSql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("+----+----------------------+-------------------------------+-------------------+");
            System.out.printf("| %-2s | %-20s | %-29s | %-17s |%n",
                    "ID", "Name", "Email", "Contact Number");
            System.out.println("+----+----------------------+-------------------------------+-------------------+");
            while (rs.next()) {
                System.out.printf("| %-2d | %-20s | %-29s | %-17s |%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact_number"));
            }
            System.out.println("+----+----------------------+-------------------------------+-------------------+");
        }
    }


    public void updateUser(int id, String name, String email, String contactNumber) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, contact_number = ? WHERE id = ?";
        try (Connection conn = DBConnectionPostgreSql.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, contactNumber);
            pstmt.setInt(4, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found.");
            }
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnectionPostgreSql.getConnection();
             //try (Connection conn = DBConnectionMySQL.getConnection();

             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }
        }
    }

}
