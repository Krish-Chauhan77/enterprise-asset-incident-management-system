import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddAsset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/asset_management";
        String username = "root";
        String password = "kay123";

        try {

            System.out.print("Asset Name: ");
            String assetName = sc.nextLine();

            System.out.print("Asset Type: ");
            String assetType = sc.nextLine();

            System.out.print("Status: ");
            String status = sc.nextLine();

            System.out.print("Assigned To: ");
            String assignedTo = sc.nextLine();

            Connection conn =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            String query =
                    "INSERT INTO assets(asset_name, asset_type, status, assigned_to) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, assetName);
            stmt.setString(2, assetType);
            stmt.setString(3, status);
            stmt.setString(4, assignedTo);

            stmt.executeUpdate();

            System.out.println("Asset Added Successfully!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
