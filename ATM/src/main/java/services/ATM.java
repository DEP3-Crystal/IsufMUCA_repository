package services;

import models.BankAccount;
import models.CreditCard;
import models.CurrencyType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ATM {
    private CreditCard card;
    private int insertedPassword;
    BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public ATM(CreditCard card, int insertedPassword) {
        this.card = card;
        this.insertedPassword = insertedPassword;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public int getInsertedPassword() {
        return insertedPassword;
    }

    public void setInsertedPassword(int insertedPassword) {
        this.insertedPassword = insertedPassword;
    }

    public boolean checkValidPassword() {
        return insertedPassword == card.getPassword();
    }

    public boolean connectToBank(ArrayList<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            if (card.getCardId().equals(account.getCard().getCardId())) {
                bankAccount = account;
                return true;
            }
        }
        return false;
    }

    public void withdrawInEuro(BigDecimal value) {
        bankAccount.withdrawInEuro(value);
    }

    public void withdrawInDollars(BigDecimal value) {
        bankAccount.withdrawInDollars(value);
    }

    //TODO
    public void withdraw(BigDecimal value, CurrencyType currency){
        if(bankAccount.getCurrency().equals(currency)){
            bankAccount.getAmount().subtract(value);
        }else{
            //TODO convert the amount
        }

    }

    public void addToDepositInEuro(BigDecimal value) {
        bankAccount.addToDepositInEuro(value);
    }

    public void addToDepositInDollars(BigDecimal value) {
        bankAccount.addToDepositInDollars(value);
    }

}
