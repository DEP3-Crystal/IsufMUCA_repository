import java.util.ArrayList;

public class Order {

    private String name;
    private String surname;

    private final ArrayList<DigitalVideoDisc> digitalVideoDiscs;

    private final ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<DigitalVideoDisc> getDigitalVideoDiscs() {
        return digitalVideoDiscs;
    }

    public void add(DigitalVideoDisc digitalVideoDisc) {
        this.digitalVideoDiscs.add(digitalVideoDisc);
    }

    public void remove(DigitalVideoDisc digitalVideoDisc) {
        this.digitalVideoDiscs.remove(digitalVideoDisc);
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public void remove(Book book) {
        this.books.remove(book);
    }

    public Order(String name, String surname) {
        this.digitalVideoDiscs = new ArrayList<>();
        this.books = new ArrayList<>();
        this.name = name;
        this.surname = surname;
    }
}
//Unused methods left there for future implementations
