package models;

import java.util.Objects;

public class CreditCard {

    private String cardId;
    private int password;

    public CreditCard(String cardId, int password) {

        this.cardId = cardId;
        this.password = password;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return password == that.password && cardId.equals(that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, password);
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
