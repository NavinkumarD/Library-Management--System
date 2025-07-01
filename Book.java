public class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry! Book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully!");
    }

    public String toString() {
        return title + " by " + author + " | " + (isAvailable ? "Available" : "Not Available");
    }

    public String toFileString() {
        return title + "," + author + "," + isAvailable;
    }

    public static Book fromFileString(String data) {
        String[] parts = data.split(",");
        Book b = new Book(parts[0], parts[1]);
        b.isAvailable = Boolean.parseBoolean(parts[2]);
        return b;
    }
}
