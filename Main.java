import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (!Login.authenticate()) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;

                case 2:
                    lib.showAllBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    title = sc.nextLine();
                    lib.searchBook(title);
                    break;

                case 4:
                    System.out.print("Enter book title to borrow: ");
                    title = sc.nextLine();
                    lib.borrowBook(title);
                    break;

                case 5:
                    System.out.print("Enter book title to return: ");
                    title = sc.nextLine();
                    lib.returnBook(title);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
