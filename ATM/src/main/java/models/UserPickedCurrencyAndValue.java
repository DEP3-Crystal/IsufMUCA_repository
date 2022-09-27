package models;

import java.math.BigDecimal;

public class UserPickedCurrencyAndValue {
    String currency;
    BigDecimal value;

    public UserPickedCurrencyAndValue(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }
}
