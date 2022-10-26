package com.models;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String clientPhoneNumber;
    private Map<Media, Integer> clientOrder;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Map<Media, Integer> getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(Map<Media, Integer> clientOrder) {
        this.clientOrder = clientOrder;
    }

    public void addOrder(Media media) {

        if (clientOrder.containsKey(media)) {
            int count = clientOrder.get(media) + 1;
            clientOrder.put(media, count);
        } else {
            clientOrder.put(media, 1);
        }
    }

    public void removeOrder(Media media) {
        if (!clientOrder.containsKey(media)) {
            return;
        }
        if (clientOrder.get(media) == 1) {
            clientOrder.remove(media);
        } else {
            int count = clientOrder.get(media) - 1;
            clientOrder.put(media, count);
        }
    }

    public Order(String clientName, String clientSurname, String clientEmail, String clientPhoneNumber) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientOrder = new HashMap<>();
    }


}
//Unused methods left there for future implementations
