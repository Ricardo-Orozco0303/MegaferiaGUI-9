/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class PrintedBook extends Book {

    private final int pageCount;
    private final int availableCopies;

    public PrintedBook(String title, ArrayList<Author> authors, String isbn, String genre, 
                       String format, double value, Publisher publisher, int pages, int copies) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.pageCount = pages;
        this.availableCopies = copies;
    }

    public int getPages() {
        return pageCount;
    }

    public int getCopies() {
        return availableCopies;
    }
}
