import java.util.*;
import java.io.*;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    final String FILE_NAME = "library_books.txt";

    public Library() {
        loadFromFile();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added!");
        saveToFile();
    }
/*************  ✨ Windsurf Command ⭐  *************/
    /**
/*******  b74372ee-bd35-4501-b3d7-c9486b971204  *******/
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.borrowBook();
                saveToFile();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.returnBook();
                saveToFile();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (Book b : books) {
                writer.write(b.toFileString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e);
        }
    }

    public void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                books.add(Book.fromFileString(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading file: " + e);
        }
    }
}
