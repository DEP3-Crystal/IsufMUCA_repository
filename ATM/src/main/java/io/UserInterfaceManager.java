package io;

import models.*;

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
        id = input.next().trim();
        System.out.println("Enter your name: ");
        name = input.next().trim();
        System.out.println("Enter your surname: ");
        surname = input.next().trim();

        for (BankAccount bankAccountObject : bank.getAllAccounts()) {

            if (bankAccountObject.getPerson().getId().equals(id) && bankAccountObject.getPerson().getName().equals(name) && bankAccountObject.getPerson().getSurname().equals(surname)) {
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
        Thread.sleep(1000);
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

    public Routine askForRoutine() {

        Routine routine = Routine.WITHDRAW;

        System.out.println("Please select your routine: \n");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit\n");
        System.out.println("Your answer: ");

        String answer = input.next().trim();

        if (answer.equals("2")) {
            routine = Routine.DEPOSIT;
        }

        return routine;
    }

    public CurrencyType choseCurrency() {

        CurrencyType[] currencies = CurrencyType.values();

        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". Pick " + currencies[i]);
        }

        String answer = "";

        while (!((answer + "").matches("[1-9]+"))) {
            System.out.println("Answer: ");
            answer = input.next();
        }

        return currencies[Integer.parseInt(answer) - 1];
    }


    public BigDecimal choseValue(CurrencyType currency) {

        System.out.println("Please pick one options from below: ");
        System.out.println("1.  10 " + currency +
                "\n" + "2.  50 " + currency +
                "\n" + "3.  100 " + currency +
                "\n" + "4.  200 " + currency +
                "\n" + "5.  500 " + currency +
                "\n" + "6. Insert the value yourself\n" + "X. Enter Any other number to quit");
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
                System.out.println("Enter the value you want for transaction: ");
                String stringValue = input.next();
                while (!stringValue.matches("[0-9]+")) {
                    System.out.println("Enter the value you want for transaction: ");
                    stringValue = input.next();
                }
                value = new BigDecimal(stringValue);
                break;

            default:
                System.out.println("It seems like you don't want to do any transaction !");
                value = new BigDecimal("0");
                break;

        }
        return value;
    }

}
