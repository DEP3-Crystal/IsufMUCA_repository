import java.util.ArrayList;

public class Order {

    private String name;
    private String surname;

    private ArrayList<DigitalVideoDisc> digitalVideoDiscs;

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

    public void setDigitalVideoDiscs(ArrayList<DigitalVideoDisc> digitalVideoDiscs) {
        this.digitalVideoDiscs = digitalVideoDiscs;
    }

    public void add(DigitalVideoDisc digitalVideoDisc) {
        this.digitalVideoDiscs.add(digitalVideoDisc);
    }

    public void remove(DigitalVideoDisc digitalVideoDisc){
        this.digitalVideoDiscs.remove(digitalVideoDisc);
    }

    public Order(String name, String surname) {
        this.digitalVideoDiscs = new ArrayList<>();
        this.name = name;
        this.surname = surname;
    }

}
