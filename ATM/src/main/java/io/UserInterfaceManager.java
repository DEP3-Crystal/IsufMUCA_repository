package io;

import models.Bank;
import models.BankAccount;
import models.CreditCard;
import models.UserPickedCurrencyAndValue;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterfaceManager {


    //Bank account which corresponds to the credit card.
    BankAccount bankAccount;
    private static final Scanner input = new Scanner(System.in);

    public CreditCard handleUserValidation(Bank bank) {
        String id, name, surname;
        CreditCard insertedCreditCard = null;

        System.out.println("Enter your id: ");
        id = input.next();
        System.out.println("Enter your name: ");
        name = input.next();
        System.out.println("Enter your surname: ");
        surname = input.next();

        for (BankAccount bankAccountObject : bank.getAllAccounts()) {

            if (bankAccountObject.getPerson().getId().equals(id) &&
                    bankAccountObject.getPerson().getName().equals(name) &&
                    bankAccountObject.getPerson().getSurname().equals(surname)) {
                bankAccount = bankAccountObject;
                insertedCreditCard = bankAccountObject.getCard();
                break;
            }
        }
        if (insertedCreditCard == null) {
            throw new RuntimeException("You are not a registered customer !!!");
        }
        return insertedCreditCard;
    }


    public void initialMessage() throws InterruptedException {
        System.out.println("Processing...");
        Thread.sleep(3000);
    }

    public void greet() {
        System.out.println("Hello " + bankAccount.getPerson().getName());
    }

    public void salute() {
        System.out.println("Good Bye " + bankAccount.getPerson().getName() + ", have a good day !");
    }

    public int askForPassword() {
        System.out.println("Enter your 4 digit password: ");
        int password = input.nextInt();
        while (!(password == bankAccount.getCard().getPassword())) {
            System.out.println("Please enter the correct password !");
            System.out.println("Enter your 4 digit password: ");
            password = input.nextInt();
        }
        System.out.println("All Good !!!");
        return password;
    }

    public String askForRoutine() {

        String routine = "Withdraw";

        System.out.println("Please select your routine: \n");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit\n");
        System.out.println("Your answer: ");

        String answer = input.next();

        if (answer.equals("2")) {
            routine = "Deposit";
        }

        return routine;
    }

    private BigDecimal pickOptionForTheValueToWithDraw() {

        System.out.println("Please pick one options from below: ");
        System.out.println("1. Withdraw 10\n" +
                "2. Withdraw 50\n" +
                "3. Withdraw 100\n" +
                "4. Withdraw 200\n" +
                "5. Withdraw 500\n" +
                "6. Insert the value yourself");
        System.out.println("Your answer: ");

        int option = input.nextInt();

        BigDecimal value;

        switch (option) {
            case 1:
                value = new BigDecimal("10");
                break;

            case 2:
                value = new BigDecimal("50");
                break;

            case 3:
                value = new BigDecimal("100");
                break;

            case 4:
                value = new BigDecimal("200");
                break;

            case 5:
                value = new BigDecimal("500");
                break;

            case 6:
                System.out.println("Enter the value you want to withdraw: ");
                String stringValue = input.next();
                while (!stringValue.matches("[0-9]+")) {
                    System.out.println("Enter the value you want to withdraw: ");
                    stringValue = input.next();
                }
                value = new BigDecimal(stringValue);
                break;

            default:
                System.out.println("It seems like you don't want to withdraw any value !");
                value = new BigDecimal("0");
                break;

        }
        return value;
    }

    public UserPickedCurrencyAndValue choseCurrencyAndPickOptionForWithdraw() {

        String currency;

        System.out.println("Press 1 for withdrawing Euro");
        System.out.println("Press 2 for withdrawing Dollars");
        System.out.println("Answer: ");
        String answer = input.next();
        while (!(answer.equals("1") || answer.equals("2"))) {
            System.out.println("Press 1 for withdrawing Euro");
            System.out.println("Press 2 for withdrawing Dollars");
            System.out.println("Answer: ");
            answer = input.next();
        }

        if (answer.equals("1")) {
            currency = "Euro";
        } else {
            currency = "Dollars";
        }
        return new UserPickedCurrencyAndValue(currency, pickOptionForTheValueToWithDraw());
    }

    public UserPickedCurrencyAndValue choseCurrencyAndAddToDeposit() {
        String currency;

        System.out.println("Press 1 for withdrawing Euro");
        System.out.println("Press 2 for withdrawing Dollars");
        System.out.println("Answer: ");
        String answer = input.next();
        while (!(answer.equals("1") || answer.equals("2"))) {
            System.out.println("Press 1 for withdrawing Euro");
            System.out.println("Press 2 for withdrawing Dollars");
            System.out.println("Answer: ");
            answer = input.next();
        }

        if (answer.equals("1")) {
            currency = "Euro";
        } else {
            currency = "Dollars";
        }

        System.out.println("Enter the value you want to add to deposit and then insert the money !");
        String value = input.next();
        while (!(value.matches("[0-9]+"))) {
            System.out.println("Re-enter the value");
            value = input.next();
        }

        return new UserPickedCurrencyAndValue(currency, new BigDecimal(value));
    }

}
