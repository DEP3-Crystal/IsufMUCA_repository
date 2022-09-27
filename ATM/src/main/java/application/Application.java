package application;

import models.Bank;
import models.CreditCard;
import models.UserPickedCurrencyAndValue;
import data.DataFromFileManager;
import io.UserInterfaceManager;
import services.ATM;

import java.util.Currency;

public class Application {
    public static void main(String[] args) {

        DataFromFileManager dataManager = null;
        ATM atm = null;

        try {

            dataManager = new DataFromFileManager("ATM/src/main/resources/accounts.properties");

            UserInterfaceManager GUI = new UserInterfaceManager();

            Bank myBank = new Bank("Atlas-Bank", dataManager.getAllBankAccounts());

            try {

                GUI.initialMessage();

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }


            CreditCard creditCard = GUI.handleUserValidation(myBank);

            int fourDigitPassword = GUI.askForPassword();

            atm = new ATM(creditCard, fourDigitPassword);

            if (atm.checkValidPassword()) {

                if (atm.connectToBank(myBank.getAllAccounts())) {

                    GUI.greet();

                    String routine = GUI.askForRoutine();

                    UserPickedCurrencyAndValue currencyValue;

                    if (routine.equals("Withdraw")) {

                        currencyValue = GUI.choseCurrencyAndPickOptionForWithdraw();

                        if (currencyValue.getCurrency().equals("Euro")) {
                            atm.withdrawInEuro(currencyValue.getValue());
                        } else if (currencyValue.getCurrency().equals("Dollars")) {
                            atm.withdrawInDollars(currencyValue.getValue());
                        }

                    } else if (routine.equals("Deposit")) {
                        currencyValue = GUI.choseCurrencyAndAddToDeposit();
                        if (currencyValue.getCurrency().equals("Euro")) {
                            atm.addToDepositInEuro(currencyValue.getValue());
                        } else if (currencyValue.getCurrency().equals("Dollars")) {
                            atm.addToDepositInDollars(currencyValue.getValue());
                        }
                    }
                }
            }

            GUI.salute();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            dataManager.setBankAccount(atm.getBankAccount().getAccountId(), atm.getBankAccount());
        }
    }
}
