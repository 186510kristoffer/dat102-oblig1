package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

    private Filmarkiv arkiv;

    @BeforeEach
    public void setUp() {
        // Opprett et tomt filmarkiv
        Film[] filmer = new Film[10];
        arkiv = new Filmarkiv(filmer, 0);

        // Legg til noen filmer
        arkiv.leggTilFilm(new Film(1, "Spielberg", "Jaws", 1975, "Universal", Sjanger.ACTION));
        arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, "Warner Bros", Sjanger.SCIFI));
    }

    @Test
    public void testLeggTilFilm() {
        // Legg til en ny film
        Film nyFilm = new Film(3, "Lucas", "Star Wars", 1977, "Fox", Sjanger.SCIFI);
        arkiv.leggTilFilm(nyFilm);

        // Sjekk antall filmer
        assertEquals(3, arkiv.antall(), "Antallet filmer skal være 3 etter å legge til ny film.");
    }
}


