/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.IAuthor;
import core.models.interfaces.IBook;
import core.models.interfaces.IPublisher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author edangulo
 */
public class Author extends Person implements IAuthor {

    private final ArrayList<Book> authoredBooks;

    public Author(long id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.authoredBooks = new ArrayList<>();
    }

    @Override
    public List<IBook> getBooks() {
        return new ArrayList<>(this.authoredBooks);
    }

    @Override
    public int getBookQuantity() {
        return this.authoredBooks.size();
    }

    public void addBook(Book book) {
        this.authoredBooks.add(book);
    }

    @Override
    public int getPublisherQuantity() {
        return countDistinctPublishers();
    }

    private int countDistinctPublishers() {
        Set<IPublisher> uniquePublishers = new HashSet<>();
        
        for (Book book : this.authoredBooks) {
            IPublisher publisher = book.getPublisher();
            if (publisher != null) {
                uniquePublishers.add(publisher);
            }
        }
        
        return uniquePublishers.size();
    }
}
