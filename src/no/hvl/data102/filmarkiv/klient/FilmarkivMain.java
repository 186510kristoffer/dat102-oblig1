package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivMain {
    public static void main(String[] args) {
    	 
    	
    	Film[] filmer = new Film[4];
    	FilmarkivADT filmarkiv = new Filmarkiv(filmer, 0);
    	Meny meny = new Meny(filmarkiv);
    	Tekstgrensesnitt tg = new Tekstgrensesnitt();
    	tg.lesFilm();
    	
    	
        
        Film film1 = new Film(1, "Christopher Nolan", "Inception", 2010,  "Warner Bros", Sjanger.ACTION);
        Film film2 = new Film(2, "Quentin Tarantino", "Pulp Fiction", 1994,  "Miramax", Sjanger.DRAMA);
        Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993,  "Universal Pictures", Sjanger.ACTION);
        Film film4 = new Film(4, "Joachim Rønning og Espen Sandberg", "Max Manus", 2008, "Nordisk Film", Sjanger.HISTORY);

               
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        

        
        System.out.println("Alle filmer i arkivet:");
        Film[] alleFilmer = filmarkiv.soekTittel("");
        if (alleFilmer != null && alleFilmer.length > 0) {
            for (Film film : alleFilmer) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer funnet.");
        }

       
        System.out.println("\nFilmer med 'Inception' i tittelen:");
        Film[] filmerMedTittel = filmarkiv.soekTittel("Inception");
        if (filmerMedTittel != null && filmerMedTittel.length > 0) {
            for (Film film : filmerMedTittel) {
                System.out.println(film);
            }
        } else {
            System.out.println("Ingen filmer funnet med denne tittelen.");
        }

       
        System.out.println("\nFilmer av produsenten 'Quentin Tarantino':");
        Film[] filmerMedProdusent = filmarkiv.soekProdusent("Quentin Tarantino");
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
        alleFilmer = filmarkiv.soekTittel("");
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

