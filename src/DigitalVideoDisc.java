public class DigitalVideoDisc {
    private String title;
    private String category; //game, movie, series
    private int priceInDollars;
    private String director;

    private int lengthInMinutes;

    public DigitalVideoDisc(String title, String category, int priceInDollars, String director,int lengthInMinutes) {
        this.title = title;
        this.category = category;
        this.priceInDollars = priceInDollars;
        this.director = director;
        this.lengthInMinutes=lengthInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }
}
