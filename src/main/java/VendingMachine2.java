import java.util.Scanner;

public class VendingMachine2 {

    public static int[] getChange(int money, int price) throws Exception {

        //handle cases when input is a negative integer
        if (money < 0 || price < 0) {
            throw new Exception();
        }

        //handle standard
        int change = money - price;
        int oneCents, fiveCents, tenCents, twentyFiveCents, fiftyCents, oneDollars;

        oneDollars = change / 100;
        change -= (oneDollars * 100);

        fiftyCents = change / 50;
        change -= (fiftyCents * 50);

        twentyFiveCents = change / 25;
        change -= (twentyFiveCents * 25);

        tenCents = change / 10;
        change -= (tenCents * 10);

        fiveCents = change / 5;
        change -= (fiveCents * 5);

        oneCents = change;

        return new int[]{oneCents, fiveCents, tenCents, twentyFiveCents, fiftyCents, oneDollars};
    }

    public static void printChange(int[] change) {
        System.out.println("The change is: ");
        System.out.println(change[0] + " 1c Coins");
        System.out.println(change[1] + " 5c Coins");
        System.out.println(change[2] + " 10c Coins");
        System.out.println(change[3] + " 25c Coins");
        System.out.println(change[4] + " 50c Coins");
        System.out.println(change[5] + " $1 Bill(s)");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product price (in float Dollars): ");
        float priceProd = scanner.nextFloat();
        System.out.println("Enter your money (in float Dollars): ");
        float moneyIns = scanner.nextFloat();
        try {
            printChange(getChange((int) (moneyIns * 100), (int) (priceProd * 100)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /*
changes = 350;
int a = changes/100 = 3.50
changes = changes - a*100;
a = changes/50 = 0
 */

}
