import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== Asset Management System =====");
            System.out.println("1. View Assets");
            System.out.println("2. View Incidents");
            System.out.println("3. Add asset");
            System.out.println("4. Update Asset status ");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    ViewAssets.main(null);
                    break;

                case 2:
                    ViewIncidents.main(null);
                    break;

                case 3:
                    AddAsset.main(null);
                    break;

                case 4:
                    UpdateAsset.main(null);
                    break;

                case 5:
                    System.out.println("goodbye");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}