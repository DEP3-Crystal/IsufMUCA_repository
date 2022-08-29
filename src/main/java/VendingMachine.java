import java.util.Scanner;

public class VendingMachine {
    public static int[] getChange(int money, int price) throws Exception {

        //handle cases when input is a negative integer
        if (money < 0 || price < 0) {
            throw new Exception();
        }
        //handle standard
        int change = money - price;
        short oneCents = 0, fiveCents = 0, tenCents = 0, twentyFiveCents = 0, fiftyCents = 0, oneDollars = 0;

        while (change > 0) {

            if (change % 100 == 0) {
                oneDollars++;
                change -= 100;
            } else if (change % 50 == 0) {
                fiftyCents++;
                change -= 50;
            } else if (change % 25 == 0) {
                twentyFiveCents++;
                change -= 25;
            } else if (change % 10 == 0) {
                tenCents++;
                change -= 10;
            } else if (change % 5 == 0) {
                fiveCents++;
                change -= 5;
            } else {
                oneCents++;
                change -= 1;
                //Because any integer % 1 = 0
            }

        }

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
        System.out.println("Enter product price:");
        float priceProd = scanner.nextFloat();
        System.out.println("Enter your money:");
        float moneyIns = scanner.nextFloat();
        try {
            printChange(getChange((int) (moneyIns * 100), (int) (priceProd * 100)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
