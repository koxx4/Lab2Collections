package org.lab.pw.collections.data;

/**
 * Klasa PersonException jest klasą wyjątków służącą do zgłaszania błędów
 * występujących przy operacjach na obiektach klasy Person.
 */
public class PersonException extends Exception {

    private static final long serialVersionUID = 1L;

    public PersonException(String message) {
        super(message);
    }

} // koniec klasy PersonException