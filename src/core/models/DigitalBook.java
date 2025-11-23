/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

public class DigitalBook extends Book {

    private final boolean hasOnlineLink;
    private final String downloadLink;

    public DigitalBook(String title, ArrayList<Author> authors, String isbn, String genre, 
                       String format, double value, Publisher publisher) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.hasOnlineLink = false;
        this.downloadLink = null;
    }

    public DigitalBook(String title, ArrayList<Author> authors, String isbn, String genre, 
                       String format, double value, Publisher publisher, String hyperlink) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.hasOnlineLink = true;
        this.downloadLink = hyperlink;
    }

    public boolean hasHyperlink() {
        return hasOnlineLink;
    }

    public String getHyperlink() {
        return downloadLink;
    }
}
