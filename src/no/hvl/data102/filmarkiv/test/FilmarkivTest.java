package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*; // For assertions
import org.junit.jupiter.api.BeforeEach; // For @BeforeEach
import org.junit.jupiter.api.Test; // For @Test

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

    private Filmarkiv arkiv;

    @BeforeEach
    public void setUp() {
        // Initialiser et Filmarkiv med plass til 10 filmer
        arkiv = new Filmarkiv(10);

        // Legg til noen testfilmer
        arkiv.leggTilFilm(new Film(1, "Spielberg", "Jaws", 1975, "Universal", Sjanger.ACTION));
        arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, "Warner Bros", Sjanger.SCIFI));
    }

    @Test
    public void testLeggTilFilm() {
        // Legg til en ny film
        Film nyFilm = new Film(3, "Lucas", "Star Wars", 1977, "Fox", Sjanger.SCIFI);
        arkiv.leggTilFilm(nyFilm);

        // Sjekk om filmen ble lagt til riktig
        assertEquals(3, arkiv.antall(), "Antallet filmer skal være 3 etter å legge til ny film.");
    }
}


