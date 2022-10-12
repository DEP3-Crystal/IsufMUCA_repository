package services;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import models.BankAccount;
import models.CreditCard;
import models.CurrencyType;
import org.json.JSONObject;

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

    public void withdraw(BigDecimal value) {
        bankAccount.withdraw(value);
    }

    public void withdraw(BigDecimal value, CurrencyType currency) {

        if (bankAccount.getCurrency().equals(currency)) {

            bankAccount.withdraw(value);

        } else {

            bankAccount.withdraw(exchange(value,currency, bankAccount.getCurrency()));
        }
    }

    public void deposit(BigDecimal value) {

        bankAccount.deposit(value);

    }


    public void deposit(BigDecimal value, CurrencyType insertedCurrency) {

        bankAccount.deposit(exchange(value, insertedCurrency, bankAccount.getCurrency()));

    }

    private BigDecimal exchange(BigDecimal value, CurrencyType insertedCurrency, CurrencyType desiredCurrency) {

        String url = "https://api.apilayer.com/exchangerates_data/convert?to="
                + desiredCurrency.toString() + "&from=" + insertedCurrency.toString() + "&amount=" + value.toString();

        try {

            HttpRequest httpRequest = new NetHttpTransport().createRequestFactory()

                    .buildGetRequest(new GenericUrl(url));

            HttpHeaders httpHeaders = httpRequest.getHeaders();

            httpHeaders.set("apikey", System.getenv("APILAYER_KEY"));


            JSONObject jsonObject = new JSONObject(httpRequest.execute().parseAsString());

            return new BigDecimal(jsonObject.getDouble("result"));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return value;
    }
}
