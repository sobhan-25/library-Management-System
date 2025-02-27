import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Load books from file
            library.getBooks().addAll(BookFileHandler.loadBooksFromFile());
        } catch (IOException e) {
            System.out.println("Error loading books from file.");
        }

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Edit Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Search Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = scanner.nextBoolean();
                    scanner.nextLine();  // Consume newline
                    library.addBook(new Book(title, author, ISBN, genre, available));
                    break;

                case 2: // View Books
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 3: // Edit Book
                    System.out.print("Enter ISBN to edit: ");
                    String editISBN = scanner.nextLine();
                    library.editBook(editISBN, scanner);
                    break;

                case 4: // Remove Book
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBook(removeISBN);
                    break;

                case 5: // Search Books
                    System.out.print("Enter title or author: ");
                    String searchQuery = scanner.nextLine();
                    library.searchBooks(searchQuery);
                    break;

                case 6: // Borrow Book
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    library.borrowBook(borrowISBN);
                    break;

                case 7: // Return Book
                    System.out.print("Enter ISBN to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;

                case 8: // Exit
                    try {
                        BookFileHandler.saveBooksToFile(library.getBooks());
                    } catch (IOException e) {
                        System.out.println("Error saving books to file.");
                    }
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
