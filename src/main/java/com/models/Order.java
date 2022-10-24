package com.models;

import java.util.ArrayList;

public class Order {

    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String clientPhoneNumber;
    private ArrayList<Media> order;

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

    public ArrayList<Media> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Media> order) {
        this.order = order;
    }

    public void addOrder(Media media) {
        order.add(media);
    }

    public void removeOrder(int index) {
        order.remove(index);
    }

    public Order(String clientName, String clientSurname, String clientEmail, String clientPhoneNumber) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.order = new ArrayList<>();
    }


}
//Unused methods left there for future implementations
