import java.io.*;
import java.util.ArrayList;

public class BookFileHandler {
    private static final String FILE_NAME = "books.txt";

    public static ArrayList<Book> loadBooksFromFile() throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                String title = bookData[0];
                String author = bookData[1];
                String ISBN = bookData[2];
                String genre = bookData[3];
                boolean available = Boolean.parseBoolean(bookData[4]);
                books.add(new Book(title, author, ISBN, genre, available));
            }
            reader.close();
        }
        return books;
    }

    public static void saveBooksToFile(ArrayList<Book> books) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Book book : books) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "," + book.getGenre() + "," + book.isAvailable());
            writer.newLine();
        }
        writer.close();
    }
}
