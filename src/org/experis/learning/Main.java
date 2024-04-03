package org.experis.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializzo lo Scanner
        Scanner nLibriScan = new Scanner(System.in);

        // Chiedo all'utente quanti libri desidera inserire
        System.out.print("Quanti libri vuoi inserire? ");
        int nLibri = Integer.parseInt(nLibriScan.nextLine());

        // Chiudo lo Scanner
        nLibriScan.close();

        // Inizializzo l'array di libri
        Libro[] libri = new Libro[nLibri];

        // Inserimento dei libri nell'array
        for (int i = 0; i < nLibri; i++) {
            // Blocco try-with-resources in cui chiedo all'utente i diversi dati del libro
            try (Scanner datiLibroScan = new Scanner(System.in)) {
                System.out.println("\nInserimento dati del libro n°" + (i + 1) + ":");
                System.out.print("Titolo: ");
                String titolo = datiLibroScan.nextLine();
                System.out.print("Numero pagine: ");
                int nPagine = Integer.parseInt(datiLibroScan.nextLine());
                System.out.print("Autore: ");
                String autore = datiLibroScan.nextLine();
                System.out.print("Editore: ");
                String editore = datiLibroScan.nextLine();

                // Invoco il costruttore della classe Libro
                libri[i] = new Libro(titolo, nPagine, autore, editore);
            } catch (IllegalArgumentException e) { // Catch dell'eventuale eccezione sollevata dal costruttore
                System.out.println("Dati inseriti non validi, riprovare");
                // Il ciclo "torna indietro" per reinserire i dati del libro correttamente
                i--;
            }
        }

        // File writing & reading

            // Scrittura dei dati dei libri su un file
                // Blocco try-with-resources in cui scrivo le informazioni dei libri in un file txt
        try (PrintWriter fWriter = new PrintWriter("./resources/catalogo_libri.txt")) {
            for (Libro l : libri) {
                fWriter.println("Titolo: " + l.getTitolo());
                fWriter.println("Numero pagine: " + l.getnPagine());
                fWriter.println("Autore: " + l.getAutore());
                fWriter.println("Editore: " + l.getEditore());
                // Separo un libro dall'altro visivamente
                fWriter.println("---------------------------------------------");
            }
        } catch (FileNotFoundException e) { // Catch dell'eventuale eccezione in cui il file non venga trovato
            System.out.println("Impossibile scrivere su file, file non trovato.");
        }

            // Lettura dei dati dei libri dal file e stampa in console
                // Blocco try-with-resources in cui leggo le informazioni dei libri dal file appena creato
        try (Scanner fScanner = new Scanner(new File("./resources/catalogo_libri.txt"))) {
            System.out.println("\nDati dei libri:\n");
            while (fScanner.hasNextLine()) {
                System.out.println(fScanner.nextLine());
            }
        } catch (FileNotFoundException e) { // Catch dell'eventuale eccezione in cui il file non venga trovato
            System.out.println("Impossibile leggere su file, file non trovato.");
        }
    }
}
