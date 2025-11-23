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
public class Audiobook extends Book {

    private final int durationInMinutes;
    private final Narrator voicePerformer;

    public Audiobook(String title, ArrayList<Author> authors, String isbn, String genre, 
                     String format, double value, Publisher publisher, int duration, Narrator narrator) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.durationInMinutes = duration;
        this.voicePerformer = narrator;
        
        registerWithNarrator();
    }

    public int getDuration() {
        return durationInMinutes;
    }

    public Narrator getNarrador() {
        return voicePerformer;
    }

    private void registerWithNarrator() {
        this.voicePerformer.addBook(this);
    }
}
