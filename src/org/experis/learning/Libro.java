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

    // Metodi

        // Getter e Setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws IllegalArgumentException {
        if(titolo.isEmpty()){
          throw new IllegalArgumentException("Il titolo non può essere vuoto");
        }
        this.titolo = titolo;
    }

    public int getnPagine() {
        return nPagine;
    }

    public void setnPagine(int nPagine) throws IllegalArgumentException {
        if(nPagine <= 0){
            throw new IllegalArgumentException("Numero di pagine non valido");
        }
        this.nPagine = nPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) throws IllegalArgumentException {
        if(autore.isEmpty()){
            throw new IllegalArgumentException("L'autore non può essere vuoto");
        }
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) throws IllegalArgumentException {
        if(editore.isEmpty()){
            throw new IllegalArgumentException("L'editore non può essere vuoto");
        }
        this.editore = editore;
    }
}
