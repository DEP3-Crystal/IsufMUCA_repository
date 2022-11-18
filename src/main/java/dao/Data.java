package dao;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String booksFileUrl = "src/main/resources/Books.json";
    private final String compactDiskFileUrl = "src/main/resources/CompactDisks.json";
    private final String digitalVideoDiscFileUrl = "src/main/resources/DigitalVideoDiscs.json";
    private final String ordersFileUrl = "src/main/resources/orders.json";

    public List<Media> getBooks() throws IOException {

        ArrayList<Media> books = new ArrayList<>();

        JsonNode booksNode = mapper.readTree(new File(booksFileUrl));

        for (JsonNode book : booksNode.get("books")) {
            JsonNode jsonAuthors = book.get("authors");
            ArrayList<String> authors = new ArrayList<>();
            for (JsonNode arrayElement : jsonAuthors) {
                authors.add(arrayElement.asText());
            }
            books.add(new Book(book.get("title").asText(),
                    book.get("category").asText(),
                    book.get("priceInDollars").asInt(),
                    book.get("type").asText(),
                    authors
            ));
        }
        return books;
    }
    public List<Media> getCompactDisks() throws IOException {

        ArrayList<Media> compactDisks = new ArrayList<>();

        JsonNode compactDisksNode = mapper.readTree(new File(compactDiskFileUrl));

        for (JsonNode compactDisk : compactDisksNode.get("compactDisks")) {

            ArrayList<Track> tracks = new ArrayList();

            for (JsonNode arrayElement : compactDisk.get("tracks")) {
                tracks.add(new Track(arrayElement.get("title").asText(), arrayElement.get("length").asInt(), arrayElement.get("path").asText()));
            }

            compactDisks.add(new CompactDisk(compactDisk.get("artist").asText(),
                    new Library<>(tracks),
                    compactDisk.get("title").asText(),
                    compactDisk.get("category").asText(),
                    compactDisk.get("priceInDollars").asInt(),
                    compactDisk.get("type").asText()));
        }
        return compactDisks;
    }
    public List<Media> getDigitalVideoDiscs() throws IOException {

        ArrayList<Media> digitalVideoDiscs = new ArrayList<>();

        JsonNode digitalVideoDiscsNode = mapper.readTree(new File(digitalVideoDiscFileUrl));

        for (JsonNode digitalVideoDisc : digitalVideoDiscsNode.get("digitalVideoDiscs")) {
            digitalVideoDiscs.add(new DigitalVideoDisc(digitalVideoDisc.get("title").asText(),
                    digitalVideoDisc.get("category").asText(),
                    digitalVideoDisc.get("priceInDollars").asInt(),
                    digitalVideoDisc.get("type").asText(),
                    digitalVideoDisc.get("director").asText(),
                    digitalVideoDisc.get("lengthInMinutes").asInt()
            ));
        }
        return digitalVideoDiscs;
    }
    public List<Media> getAll() throws IOException {

        ArrayList<Media> all = new ArrayList<>();

        JsonNode booksNode = mapper.readTree(new File(booksFileUrl));

        for (JsonNode book : booksNode.get("books")) {
            JsonNode jsonAuthors = book.get("authors");
            ArrayList<String> authors = new ArrayList<>();
            for (JsonNode arrayElement : jsonAuthors) {
                authors.add(arrayElement.asText());
            }
            all.add(new Book(book.get("title").asText(),
                    book.get("category").asText(),
                    book.get("priceInDollars").asInt(),
                    book.get("type").asText(),
                    authors
            ));
        }
        JsonNode compactDisksNode = mapper.readTree(new File(compactDiskFileUrl));

        for (JsonNode compactDisk : compactDisksNode.get("compactDisks")) {

            ArrayList<Track> tracks = new ArrayList();

            for (JsonNode arrayElement : compactDisk.get("tracks")) {
                tracks.add(new Track(arrayElement.get("title").asText(), arrayElement.get("length").asInt(), arrayElement.get("path").asText()));
            }
            all.add(new CompactDisk(compactDisk.get("artist").asText(), new Library<>(tracks)
                    ,
                    compactDisk.get("title").asText(),
                    compactDisk.get("category").asText(),
                    compactDisk.get("priceInDollars").asInt(),
                    compactDisk.get("type").asText()));
        }
        JsonNode digitalVideoDiscsNode = mapper.readTree(new File(digitalVideoDiscFileUrl));

        for (JsonNode digitalVideoDisc : digitalVideoDiscsNode.get("digitalVideoDiscs")) {
            all.add(new DigitalVideoDisc(digitalVideoDisc.get("title").asText(),
                    digitalVideoDisc.get("category").asText(),
                    digitalVideoDisc.get("priceInDollars").asInt(),
                    digitalVideoDisc.get("type").asText(),
                    digitalVideoDisc.get("director").asText(),
                    digitalVideoDisc.get("lengthInMinutes").asInt()
            ));
        }
        return all;
    }
    public void writeOrder(Order order) throws IOException {
        mapper.writeValue(new File(ordersFileUrl), order);
    }
}