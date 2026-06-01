import java.sql.*;

public class ViewAssets {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/asset_management";

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
                    "SELECT * FROM assets";

            Statement stmt =
                    conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("asset_name")
                                + " | "
                                + rs.getString("asset_type")
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
