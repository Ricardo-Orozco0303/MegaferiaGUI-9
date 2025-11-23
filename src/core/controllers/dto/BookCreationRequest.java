package core.controllers.dto;

import java.util.List;

public class BookCreationRequest {

    private final String title;
    private final List<String> authorIds;
    private final String isbn;
    private final String genre;
    private final String format;
    private final String price;
    private final String publisherNit;
    private final BookType type;
    private final String pages;
    private final String copies;
    private final String hyperlink;
    private final String duration;
    private final String narratorId;

    public BookCreationRequest(
            String title,
            List<String> authorIds,
            String isbn,
            String genre,
            String format,
            String price,
            String publisherNit,
            BookType type,
            String pages,
            String copies,
            String hyperlink,
            String duration,
            String narratorId) {
        this.title = title;
        this.authorIds = authorIds;
        this.isbn = isbn;
        this.genre = genre;
        this.format = format;
        this.price = price;
        this.publisherNit = publisherNit;
        this.type = type;
        this.pages = pages;
        this.copies = copies;
        this.hyperlink = hyperlink;
        this.duration = duration;
        this.narratorId = narratorId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthorIds() {
        return authorIds;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public String getPrice() {
        return price;
    }

    public String getPublisherNit() {
        return publisherNit;
    }

    public BookType getType() {
        return type;
    }

    public String getPages() {
        return pages;
    }

    public String getCopies() {
        return copies;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public String getDuration() {
        return duration;
    }

    public String getNarratorId() {
        return narratorId;
    }
}
