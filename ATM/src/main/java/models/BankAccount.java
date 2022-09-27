package models;

import java.math.BigDecimal;

public class BankAccount {
    private String accountId;
    private Person person;
    private CreditCard card;

    //TODO remove these properties depositInEuro, depositInDollars
    private BigDecimal depositInEuro;
    private BigDecimal depositInDollars;

    private CurrencyType currency;

    private BigDecimal amount;

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BankAccount(String accountId, Person person, CreditCard card, BigDecimal depositInEuro, BigDecimal depositInDollars) {
        this.accountId = accountId;
        this.person = person;
        this.card = card;
        this.depositInEuro = depositInEuro;
        this.depositInDollars = depositInDollars;
    }

    public String getAccountId() {
        return accountId;
    }

    public Person getPerson() {
        return person;
    }

    public CreditCard getCard() {
        return card;
    }

    public BigDecimal getDepositInEuro() {
        return depositInEuro;
    }

    public BigDecimal getDepositInDollars() {
        return depositInDollars;
    }

    public void withdrawInEuro(BigDecimal value) {
        if (depositInEuro.compareTo(value) >= 0) {
            depositInEuro = depositInEuro.subtract(value);
        } else {
            throw new RuntimeException("Invalid withdraw value, you cannot withdraw more than you have in your account");
        }
    }

    public void addToDepositInEuro(BigDecimal value) {
        depositInEuro = depositInEuro.add(value);
    }

    public void withdrawInDollars(BigDecimal value) {
        if (depositInEuro.compareTo(value) >= 0) {
            depositInDollars = depositInDollars.subtract(value);
        } else {
            throw new RuntimeException("Invalid withdraw value, you cannot withdraw more than you have in your account");
        }
    }

    public void addToDepositInDollars(BigDecimal value) {
        depositInDollars.add(value);
    }


}
