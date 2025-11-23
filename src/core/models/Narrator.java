/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.INarrator;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Narrator extends Person implements INarrator {

    private final ArrayList<Audiobook> narratedAudiobooks;

    public Narrator(long id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.narratedAudiobooks = new ArrayList<>();
    }

    @Override
    public int getBookQuantity() {
        return this.narratedAudiobooks.size();
    }

    public void addBook(Audiobook book) {
        this.narratedAudiobooks.add(book);
    }
}
