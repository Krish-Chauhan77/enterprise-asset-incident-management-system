import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/asset_management";
        String username = "root";
        String password = "kay123";

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String enteredUsername = sc.nextLine();

        System.out.print("Password: ");
        String enteredPassword = sc.nextLine();

        try {
            Connection conn =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            String query =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, enteredUsername);
            stmt.setString(2, enteredPassword);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                System.out.println("Login Successful");
            }
            else {
                System.out.println("Invalid Credentials");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
