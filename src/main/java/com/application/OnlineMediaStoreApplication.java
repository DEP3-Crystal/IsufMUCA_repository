package com.application;

import com.dao.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.io.Gui;
import com.models.MediaType;
import com.services.OnlineMediaStoreService;

import java.io.IOException;

public class OnlineMediaStoreApplication {
    public static void main(String[] args) throws IOException {

        Data data = new Data();

        Gui gui = new Gui();

        gui.greet();

        OnlineMediaStoreService store = new OnlineMediaStoreService(gui.promptUserData());

        do {

            String answer = gui.menu();
            try {

                if (answer.equals("1")) {
                    gui.display(data.getBooks(), MediaType.BOOK);
                    gui.display(data.getCompactDisks(), MediaType.COMPACT_DISK);
                    gui.display(data.getDigitalVideoDiscs(), MediaType.DIGITAL_VIDEO_DISK);
                } else if (answer.equals("2")) {
                    gui.display(data.getBooks(), MediaType.BOOK);
                } else if (answer.equals("3")) {
                    gui.display(data.getCompactDisks(), MediaType.COMPACT_DISK);
                } else if (answer.equals("4")) {
                    gui.display(data.getDigitalVideoDiscs(), MediaType.DIGITAL_VIDEO_DISK);
                } else if (answer.equals("5")) {
                    gui.displayYourOrder(store.getOrder().getClientOrder());
                }

                store.addOrder(store.searchForTitleInMedia(gui.order(), data.getAll()));

            } catch (NullPointerException exception) {
                gui.warnInvalidInput();
            }

        } while (!gui.quit());

        gui.salute();

        data.writeOrder(store.getOrder());

    }
}
