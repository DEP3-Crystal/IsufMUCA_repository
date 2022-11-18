package models;

import java.util.List;

public class Library<T> {
    List<T> titles;

    public Library(List<T> titles) {
        this.titles = titles;
    }

    public void add(T title) {
        if (title != null)
            titles.add(title);
    }

    public void remove(int index) {
        titles.remove(index);
    }

    public void remove(String title) {
        titles.remove(titles.indexOf(title));
    }

    public List<T> getTitles() {
        return titles;
    }

    public void setTitles(List<T> titles) {
        this.titles = titles;
    }
}
