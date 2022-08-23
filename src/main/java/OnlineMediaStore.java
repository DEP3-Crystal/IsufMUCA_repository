import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineMediaStore {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<DigitalVideoDisc> loadedDiscs;
    private static ArrayList<Book> loadedBooks;


    private static final int EXIT = -1;

    private static void refreshLoadedMedia() {
        try {
            loadedDiscs = DataFromProperties.readAllDVD();
            loadedBooks = DataFromProperties.readAllBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int prompt() throws IOException {
        System.out.println("Hello !");
        System.out.println("How would you like to enter :\n1.User\n2.Manager\n3.Leave");
        System.out.println("Answer:");
        int intAnswer = input.nextInt();
        if (intAnswer == 1) {
            enterUserMode();
            return intAnswer;
        } else if (intAnswer == 2) {
            enterManagerMode();
            return intAnswer;
        }
        return EXIT;

    }

    public static void enterUserMode() {
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your surname: ");
        String surname = input.next();
        Order order = new Order(name, surname);


        while (true) {
            refreshLoadedMedia();

            System.out.println(" All movies :");
            for (DigitalVideoDisc movie : loadedDiscs)
                System.out.println(movie.toString());
            System.out.println("===========================================================================================================================");
            System.out.println("All Books: ");
            for (Book book : loadedBooks)
                System.out.println(book.toString());

            System.out.println("Answer with 1 to pick a movie\nAnswer with 2 to pick a book");
            int answer = input.nextInt();
            int intAnswer;
            switch (answer) {

                case 1:
                    System.out.println("Enter key: ");
                    intAnswer = input.nextInt();
                    if (intAnswer <= loadedDiscs.size() && intAnswer >= 0) {
                        order.add(loadedDiscs.get(intAnswer - 1));
                        orders.add(order);
                    } else
                        System.out.println("Invalid pick !");
                    break;

                case 2:
                    intAnswer = input.nextInt();
                    if (intAnswer <= loadedBooks.size() && intAnswer >= 0) {
                        order.add(loadedBooks.get(intAnswer - 1));
                        orders.add(order);
                    } else
                        System.out.println("Invalid pick !");
                    break;

                default:
                    System.out.println("Invalid pick !");
                    break;
            }

            System.out.println("You want to continue :\nyes\nno");
            String strAnswer = input.next();

            if (strAnswer.equals("no")) {
                break;
            }
        }
    }

    public static void enterManagerMode() throws IOException {
        System.out.println("What would you like to do:\n1.Insert a movie\n2.Insert a book\n3.View all orders");
        int intDecision = input.nextInt();
        switch (intDecision) {
            case 1:
                while (true) {
                    System.out.println("Enter data to save a movie into database :");
                    System.out.println("Title: ");
                    String title = input.next();
                    System.out.println("Category: ");
                    String category = input.next();
                    System.out.println("Money in dollars:");
                    int money = input.nextInt();
                    System.out.println("Director: ");
                    String director = input.next();
                    System.out.println("Length in minutes: ");
                    int length = input.nextInt();
                    DataFromProperties.addProperty(new DigitalVideoDisc(title, category, money, MediaType.MOVIE.toString(), director, length));

                    System.out.println("Adding again \nyes\nno");
                    System.out.print("Answer: ");
                    String strAnswer = input.next();

                    if (strAnswer.equals("no"))
                        break;
                }
                break;
            case 2:
                while (true) {
                    System.out.println("Enter data to save a book into database :");
                    System.out.println("Title: ");
                    String title = input.next();
                    System.out.println("Category: ");
                    String category = input.next();
                    System.out.println("Money in dollars:");
                    int money = input.nextInt();
                    System.out.println("Authors: ");
                    ArrayList<String> authors = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        authors.add(input.next());
                    }
                    DataFromProperties.addProperty(new Book(title, category, money, MediaType.BOOK.toString(), authors));
                    System.out.println("Adding again \nyes\nno");
                    System.out.print("Answer: ");
                    String strAnswer = input.next();
                    if (strAnswer.equals("no"))
                        break;
                }
                break;
            case 3:
                System.out.println("All orders:\n");
                if (orders.isEmpty())
                    System.out.println("There isn't any order yet !");
                else {
                    for (Order order : orders) {
                        System.out.println(order.getName() + " " + order.getSurname());
                        for (DigitalVideoDisc el : order.getDigitalVideoDiscs())
                            System.out.println(el.getTitle() + " " + el.getCategory() + " " + el.getDirector() + " $" + el.getPriceInDollars() + " " + el.getLengthInMinutes() + " min");
                    }
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            int ans = prompt();
            if (ans == EXIT)
                break;
        }
    }
}
