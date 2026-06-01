import java.sql.*;

public class ViewIncidents {

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

            Statement stmt =
                    conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM incidents");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("title")
                                + " | "
                                + rs.getString("priority")
                                + " | "
                                + rs.getString("status")
                );
            }

            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}