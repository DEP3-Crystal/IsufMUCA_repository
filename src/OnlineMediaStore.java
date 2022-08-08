import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineMediaStore {
    private static final Scanner input = new Scanner(System.in);
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<DigitalVideoDisc> loadedDiscs;


    private static final int EXIT = -1;

    private static void refreshLoadedDiscs() {
        try {
            loadedDiscs = DataFromProperties.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int prompt() throws IOException {
        System.out.println("Hello !");
        System.out.println("How would you like to enter :\n1.User\n2.Manager\n3.Leave");

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

    public static void enterUserMode() throws IOException {
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your surname: ");
        String surname = input.next();
        Order order = new Order(name, surname);


        while (true) {

            System.out.println(" All movies :");
            refreshLoadedDiscs();
            DataFromProperties.printAll();

            System.out.println("Pick a movie: ");
            int intAnswer = input.nextInt();
            if (intAnswer <= loadedDiscs.size() && intAnswer >= 0) {
                order.add(loadedDiscs.get(intAnswer - 1));
                orders.add(order);
            } else
                System.out.println("Invalid pick !");

            System.out.println("You want to continue :\nyes\nno");
            String strAnswer = input.next();

            if (strAnswer.equals("no")) {
                break;
            }
        }

    }

    public static void enterManagerMode() throws IOException {
        System.out.println("What would you like to do:\n1.Insert a movie\n2.View all orders");
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
                    DataFromProperties.addProperty(new DigitalVideoDisc(title, category, money, director, length));

                    System.out.println("Adding again \nyes\nno");
                    System.out.print("Answer: ");
                    String strAnswer = input.next();

                    if (strAnswer.equals("no"))
                        break;
                }
                break;
            case 2:
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
