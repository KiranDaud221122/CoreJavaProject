import CrudOperations.UserEntity;
import CrudOperations.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("\n==== USER CRUD MENU ====");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = sc.nextLine();

                    userService.addUser(
                            new UserEntity(name, email, contactNumber)
                    );
                    break;
                case 2:
                    userService.getAllUsers();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Name: ");
                    String updName = sc.nextLine();

                    System.out.print("Enter new Email: ");
                    String updEmail = sc.nextLine();

                    System.out.print("Enter new Contact Number: ");
                    String updContactNumber = sc.nextLine();

                    userService.updateUser(updId, updName, updEmail, updContactNumber);
                    break;

                case 4:
                    System.out.print("Enter ID i.e 1: ");
                    int delUser = sc.nextInt();
                    userService.deleteUser(delUser);
                    break;

                case 5:
                    System.out.println("Bye.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}





