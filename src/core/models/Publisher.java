/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.IBook;
import core.models.interfaces.IManager;
import core.models.interfaces.IPublisher;
import core.models.interfaces.IStand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edangulo
 */
public class Publisher implements IPublisher {

    private final String businessIdentifier;
    private final String companyName;
    private final String physicalAddress;
    private final Manager designatedManager;
    private final ArrayList<Book> catalogBooks;
    private final ArrayList<Stand> rentedStands;

    public Publisher(String nit, String name, String address, Manager manager) {
        this.businessIdentifier = nit;
        this.companyName = name;
        this.physicalAddress = address;
        this.designatedManager = manager;
        this.catalogBooks = new ArrayList<>();
        this.rentedStands = new ArrayList<>();
        
        establishManagerRelationship();
    }

    @Override
    public String getNit() {
        return businessIdentifier;
    }

    @Override
    public String getName() {
        return companyName;
    }

    @Override
    public String getAddress() {
        return physicalAddress;
    }

    @Override
    public IManager getManager() {
        return designatedManager;
    }

    @Override
    public int getStandQuantity() {
        return this.rentedStands.size();
    }

    @Override
    public List<IBook> getBooks() {
        return new ArrayList<>(this.catalogBooks);
    }

    @Override
    public List<IStand> getStands() {
        return new ArrayList<>(this.rentedStands);
    }

    public void addBook(Book book) {
        this.catalogBooks.add(book);
    }

    public void addStand(Stand stand) {
        this.rentedStands.add(stand);
    }

    private void establishManagerRelationship() {
        this.designatedManager.setPublisher(this);
    }
}
