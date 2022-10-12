package application;

import data.DataFromFile;
import data.DataManager;
import io.UserInterfaceManager;
import models.*;
import services.ATM;

import java.io.IOException;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        String fileURL = "ATM/src/main/resources/accountsCSV.csv";

        DataManager data = new DataFromFile(fileURL);

        Bank bank = new Bank("BKT", data.getAllBankAccounts());

        BankAccount currentBankAccount;

        UserInterfaceManager gui = new UserInterfaceManager();


        ATM atm = new ATM(gui.handleUserValidation(bank), gui.askForPassword());

        try {
            gui.initialMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        gui.greet();

        if (atm.checkValidPassword() && atm.connectToBank(bank.getAllAccounts())) {

            BigDecimal value;

            CurrencyType currency;

            currentBankAccount = atm.getBankAccount();

            Routine routine = gui.askForRoutine();

            if (routine.equals(Routine.WITHDRAW)) {

                currency = gui.choseCurrency();

                value = gui.choseValue(currency);

                if (currency.equals(currentBankAccount.getCurrency())) {

                    atm.withdraw(value);

                } else {

                    atm.withdraw(value, currency);

                }
            } else if (routine.equals(Routine.DEPOSIT)) {

                currency = gui.choseCurrency();

                value = gui.choseValue(currency);

                if (currency.equals(currentBankAccount.getCurrency())) {

                    atm.deposit(value);

                } else {

                    atm.deposit(value, currency);

                }
            }
        }

        try {
            data.update(bank.getAllAccounts());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        gui.salute();
    }
}
