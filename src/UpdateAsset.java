import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateAsset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/asset_management";
        String username = "root";
        String password = "kay123";

        try {

            System.out.print("Enter Asset ID: ");
            int assetId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter New Status: ");
            String newStatus = sc.nextLine();

            Connection conn =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            String query =
                    "UPDATE assets SET status=? WHERE id=?";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, newStatus);
            stmt.setInt(2, assetId);

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0) {
                System.out.println("Asset Updated Successfully!");
            } else {
                System.out.println("Asset ID Not Found!");
            }

            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}