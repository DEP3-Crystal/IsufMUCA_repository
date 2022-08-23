import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

public class DataFromProperties {
    private static final Properties media = new Properties();
    private static final FileInputStream in;
    private static final FileOutputStream out;
    private static int key = 1;

    static {
        try {
            in = new FileInputStream("src/main/resources/media.properties");
            out = new FileOutputStream("src/main/resources/media.properties", true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addProperty(DigitalVideoDisc digitalVideoDisc) throws IOException {
        media.setProperty(key + "", digitalVideoDisc.getTitle() + " " + digitalVideoDisc.getCategory() + " " + digitalVideoDisc.getPriceInDollars() + " " + digitalVideoDisc.getType() + " " + digitalVideoDisc.getDirector() + " " + digitalVideoDisc.getLengthInMinutes());
        key++;
        media.store(out, "Movie");
    }

    public static void addProperty(Book book) throws IOException {
        ArrayList<String> authors = book.getAuthors();
        media.setProperty(key + "", book.getTitle() + " " + book.getCategory() + " " + book.getPriceInDollars() + " " + book.getType() + " " + authors.get(0) + " " + authors.get(1) + " " + authors.get(2));
        key++;
        media.store(out, "Book");
    }

    public static void printAll() throws IOException {
        media.load(in);
        Enumeration<String> enums = (Enumeration<String>) media.propertyNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String[] data = media.getProperty(key).split(" ");
            if (data[3].equals(MediaType.MOVIE.toString()))
                //Handle for movies
                System.out.println(key + " : " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4] + data[5]);
            else {
                //Handle for Books
                System.out.println(key + " : " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + data[4] + data[5] + data[6]);
            }
        }
    }

    public static ArrayList<DigitalVideoDisc> readAllDVD() throws IOException {
        media.load(in);
        ArrayList<DigitalVideoDisc> list = new ArrayList<>();
        Enumeration<String> enums = (Enumeration<String>) media.propertyNames(); //IntelliJ wrong warning for use case
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String[] data = media.getProperty(key).split(" ");
            if (data[3].equals(MediaType.MOVIE.toString())) {
                list.add(new DigitalVideoDisc(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5])));
            }
        }
        return list;
    }

    public static ArrayList<Book> readAllBooks() throws IOException {
        media.load(in);
        ArrayList<Book> list = new ArrayList<>();

        Enumeration<String> enums = (Enumeration<String>) media.propertyNames(); //IntelliJ wrong warning for use case
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String[] data = media.getProperty(key).split(" ");
            if (data[3].equals(MediaType.BOOK.toString())) {
                list.add(new Book(data[0], data[1], Integer.parseInt(data[2]), data[3], new ArrayList<>(Arrays.asList(data[4], data[5], data[6]))));
            }
        }
        return list;
    }
}
