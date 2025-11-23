/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.IPublisher;
import core.models.interfaces.IStand;
import java.util.ArrayList;
import java.util.List;

public class Stand implements IStand {

    private final long id;
    private final double rentalPrice;
    private final ArrayList<Publisher> occupyingPublishers;

    public Stand(long id, double price) {
        this.id = id;
        this.rentalPrice = price;
        this.occupyingPublishers = new ArrayList<>();
    }

    public void addPublisher(Publisher publisher) {
        this.occupyingPublishers.add(publisher);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return rentalPrice;
    }

    @Override
    public List<IPublisher> getPublishers() {
        return new ArrayList<>(this.occupyingPublishers);
    }

    @Override
    public int getPublisherQuantity() {
        return this.occupyingPublishers.size();
    }
}
