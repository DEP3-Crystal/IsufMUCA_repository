import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class DataFromProperties {
    private static Properties media = new Properties();
    private static FileInputStream in;
    private static FileOutputStream out;
    private static int key = 1;

    static {
        try {
            in = new FileInputStream("media.properties");
            out = new FileOutputStream("media.properties", true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addProperty(DigitalVideoDisc digitalVideoDisc) throws IOException {

        media.setProperty(key + "", digitalVideoDisc.getTitle() + " " + digitalVideoDisc.getCategory() + " " + digitalVideoDisc.getPriceInDollars() + " " + digitalVideoDisc.getDirector() + " " + digitalVideoDisc.getLengthInMinutes());
        key++;
        media.store(out, "Movies");
    }

    public DigitalVideoDisc readLine(int key) {

        String record = media.getProperty(key + "");
        String[] data = record.split(" ");
        return new DigitalVideoDisc(data[0], data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));

    }

    public static void printAll() throws IOException {
        media.load(in);
        Enumeration<String> enums = (Enumeration<String>) media.propertyNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String[] data = media.getProperty(key).split(" ");
            System.out.println(key + " : " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
        }
    }

    public static ArrayList<DigitalVideoDisc> readAll() throws IOException {
        media.load(in);
        ArrayList<DigitalVideoDisc> list = new ArrayList<>();

        Enumeration<String> enums = (Enumeration<String>) media.propertyNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String[] data = media.getProperty(key).split(" ");
            list.add(new DigitalVideoDisc(data[0], data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4])));
        }
        return list;
    }

    public static void addProperty(String key, DigitalVideoDisc digitalVideoDisc) throws IOException {

        media.setProperty(key, digitalVideoDisc.getTitle() + " " + digitalVideoDisc.getCategory() + " " + digitalVideoDisc.getPriceInDollars() + " " + digitalVideoDisc.getDirector() + " " + digitalVideoDisc.getLengthInMinutes());
    media.store(out,"Movies");
    }
}
