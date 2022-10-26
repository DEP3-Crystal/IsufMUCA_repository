package com.models;

public abstract class Media {
    protected String title;
    protected String category; //value can be game, movie, series
    protected int priceInDollars;

    protected String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Media(String title, String category, int priceInDollars, String type) {
        this.title = title;
        this.category = category;
        this.priceInDollars = priceInDollars;
        this.type = type;
    }
}
