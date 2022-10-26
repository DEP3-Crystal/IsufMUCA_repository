package com.services;

import com.models.Media;
import com.models.Order;

import java.util.List;

public class OnlineMediaStoreService {
    private Order order;

    public OnlineMediaStoreService(Order order) {
        this.order = order;
    }

    public void addOrder(Media media) {
        order.addOrder(media);
    }

    public Order getOrder() {
        return order;
    }

    public Media searchForTitleInMedia(String title, List<Media> media) {

        for (Media m : media) {
            if (m.getTitle().equals(title) || m.getTitle().contains(title)) {
                return m;
            }
        }
        return null;
    }
}
