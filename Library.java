import java.util.ArrayList;
import java.util.*;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void editBook(String ISBN, Scanner scanner) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                System.out.println("Editing book: " + b.getTitle());
                System.out.print("Enter new title: ");
                b.setTitle(scanner.nextLine());
                System.out.print("Enter new author: ");
                b.setAuthor(scanner.nextLine());
                System.out.print("Enter new genre: ");
                b.setGenre(scanner.nextLine());
                System.out.print("Available (true/false): ");
                b.setAvailable(scanner.nextBoolean());
                scanner.nextLine();  // Consume newline
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBooks(String query) {
        for (Book b : books) {
            if (b.getTitle().contains(query) || b.getAuthor().contains(query)) {
                System.out.println(b);
            }
        }
    }

    public void borrowBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Sorry, this book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                b.setAvailable(true);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
