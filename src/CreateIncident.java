import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateIncident {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/asset_management";
        String username = "root";
        String password = "kay123";

        try {
            Connection conn =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            String query =
                    "INSERT INTO incidents(title, description, priority, status, created_by) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, "Network Switch Offline");
            stmt.setString(2, "Switch in Lab A is not responding");
            stmt.setString(3, "High");
            stmt.setString(4, "Open");
            stmt.setString(5, "Krish");

            stmt.executeUpdate();

            System.out.println("Incident Created!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
