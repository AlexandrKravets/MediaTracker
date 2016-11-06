package Media;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Kravets on 19.10.2016.
 */
public class BookIOUtils {
    public static final String CSV_DELIMITER = ";";
    public static final String COMA_DELIMITER = ",";
    private static int yr = Calendar.getInstance().get(Calendar.YEAR);


    public static void writeBookIntoFile(String fileName, List<File> book) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writeBook(writer, book);
        }
    }

    private static void writeBook(PrintWriter writer, List<File> books) {

        for (File book : books) {
            Book b = (Book) book;
            writer.println(bookToOutputString(b));
        }
    }


    private static String bookToOutputString(Book book) {
        return book.getId() +
                "|" + book.getName() +
                "|" + book.getAuthor() +
                "|" + book.getCountry() +
                "|" + book.getGenre() +
                "|" + book.getRang() +
                "|" + book.getReleaseYear() +
                "|" + book.getPublishing() +
                "|" + book.getPages();
    }




    public static List<File> readBookFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {
            return readBook(reader);
        }
    }


    public static List<File> readBook(BufferedReader reader) throws IOException {
        List<File> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Book file = parseBook(line);
            if (file != null) {
                res.add(file);
            }
        }

        return res;
    }
//    book1.setId(444);
//        book1.setName("Harry Potter");
//        book1.setAuthor("Joahn Rowling");
//        book1.setCountry("Britain");
//        book1.setGenre(Arrays.asList(BookGenre.CHILDRENS, BookGenre.FANTASY));
//        book1.setRang(4.68);
//        book1.setReleaseYear(2001);
//        book1.setPublishing("Piter");
//        book1.setPages(890

    public static Book parseBook(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (!isInt(tokens[6])) {
            return null;
        }

        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        String author = tokens[2];
        String country = tokens[3];

        List<BookGenre> genres = parseGenre(tokens[4]);
        if (genres == null) {
            return null;
        }
        Double rang = Double.parseDouble(tokens[5]);

        int releaseYear = Integer.parseInt(tokens[6]);
        if (!isReleaseYear(releaseYear)) {
            return null;
        }




        int pages = Integer.parseInt(tokens[8]);
        String publishing = tokens[7];




        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setReleaseYear(releaseYear);
        book.setRang(rang);
        book.setGenre(genres);
        book.setCountry(country);
        book.setPublishing(publishing);
        book.setPages(pages);


        return book;
    }


    public static List<BookGenre> parseGenre(String line) {
        String[] genreTokens = line.split(COMA_DELIMITER);
        List<BookGenre> genres = new ArrayList<>();

        for (String genreToken : genreTokens) {
            try {
                BookGenre genre = BookGenre.valueOf(genreToken.trim());
                genres.add(genre);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return genres;
    }

    public static boolean isReleaseYear(int year) {
        return year >= 1000 && year <= yr;
    }


    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




