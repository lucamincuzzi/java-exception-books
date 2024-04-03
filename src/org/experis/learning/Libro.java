package org.experis.learning;

public class Libro {
    // Attributi
    private String titolo;
    private int nPagine;
    private String autore;
    private String editore;

    // Costruttori

    public Libro(String titolo, int nPagine, String autore, String editore) throws IllegalArgumentException {
        if(titolo.isEmpty() || nPagine <= 0 || autore.isEmpty() || editore.isEmpty()){
            throw new IllegalArgumentException("Dati non validi, riprovare");
        }
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.autore = autore;
        this.editore = editore;
    }
}
