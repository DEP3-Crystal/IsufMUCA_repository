package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private final String accountId;
    private final Person person;
    private final CreditCard card;

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

    public BankAccount(String accountId, Person person, CreditCard card, CurrencyType currency, BigDecimal amount) {
        this.accountId = accountId;
        this.person = person;
        this.card = card;
        this.currency = currency;
        this.amount = amount;

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


    public void withdraw(BigDecimal value) {
        if (amount.compareTo(value) >= 0) {
            amount = amount.subtract(value);
        } else {
            throw new RuntimeException("Invalid withdraw value, you cannot withdraw more than you have in your account");
        }
    }

    public void deposit(BigDecimal value) {
        amount = amount.add(value);
    }


}
