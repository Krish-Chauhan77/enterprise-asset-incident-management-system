import java.sql.*;
import java.util.Scanner;

public class SearchAsset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/asset_management";
        String username = "root";
        String password = "kay123";

        try {

            System.out.print("Enter Asset Name: ");
            String search = sc.nextLine();

            Connection conn =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            String query =
                    "SELECT * FROM assets WHERE asset_name LIKE ?";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, "%" + search + "%");

            ResultSet rs = stmt.executeQuery();

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