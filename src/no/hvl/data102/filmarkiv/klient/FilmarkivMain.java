package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.*;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.*;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmarkivADT filmarkiv = new Filmarkiv2();

        
        Film film1 = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros");
        Film film2 = new Film(2, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax");
        Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        
        System.out.println("Alle filmer i arkivet:");
        Film[] alleFilmer = filmarkiv.sokTittel("");
        if (alleFilmer != null && alleFilmer.length > 0) {
            for (Film film : alleFilmer) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer funnet.");
        }

       
        System.out.println("\nFilmer med 'Inception' i tittelen:");
        Film[] filmerMedTittel = filmarkiv.sokTittel("Inception");
        if (filmerMedTittel != null && filmerMedTittel.length > 0) {
            for (Film film : filmerMedTittel) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer funnet med denne tittelen.");
        }

       
        System.out.println("\nFilmer av produsenten 'Quentin Tarantino':");
        Film[] filmerMedProdusent = filmarkiv.sokProdusent("Quentin Tarantino");
        if (filmerMedProdusent != null && filmerMedProdusent.length > 0) {
            for (Film film : filmerMedProdusent) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer funnet av denne produsenten.");
        }

    
        System.out.println("\nAntall filmer i ACTION-sjangeren: " + filmarkiv.antall(Sjanger.ACTION));

        
        System.out.println("\nSletter filmen med nummer 2...");
        boolean slettet = filmarkiv.slettFilm(2);
        if (slettet) {
            System.out.println("Film med nummer 2 ble slettet.");
        } else {
            System.out.println("Fant ikke film med nummer 2, kunne ikke slette.");
        }

       
        System.out.println("\nAlle filmer i arkivet etter sletting:");
        alleFilmer = filmarkiv.sokTittel("");
        if (alleFilmer != null && alleFilmer.length > 0) {
            for (Film film : alleFilmer) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer igjen i arkivet.");
        }

        
        System.out.println("\nTotalt antall filmer i arkivet: " + filmarkiv.antall());
    }
}

