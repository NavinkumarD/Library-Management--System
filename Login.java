import java.util.Scanner;

public class Login {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }
}
