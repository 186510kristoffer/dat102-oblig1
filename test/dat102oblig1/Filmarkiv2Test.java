package dat102oblig1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {

    private Filmarkiv2 arkiv;
    
    @BeforeEach
    public void setUp() {
        arkiv = new Filmarkiv2();

        // Legger til noen filmer i arkivet
        arkiv.leggTilFilm(new Film(1, "Spielberg", "Jaws", 1975, "Universal", Sjanger.ACTION));
        arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, "Warner Bros", Sjanger.SCIFI));
    }
    
    @Test
    public void testLeggTilFilm() {
        Film nyFilm = new Film(3, "Lucas", "Star Wars", 1977, "Fox", Sjanger.SCIFI);
        arkiv.leggTilFilm(nyFilm);

        
        assertEquals(3, arkiv.antall(), "Forventet totalt 3 filmer i arkivet etter å legge til en ny film.");

        Film funnetFilm = arkiv.finnFilm(3);
        assertNotNull(funnetFilm, "Den nye filmen skal være lagt til i arkivet.");
        assertEquals("Star Wars", funnetFilm.getTittel(), "Den nye filmen skal ha tittelen 'Star Wars'.");
    }
    
    @Test
    public void testFinnFilm() {
        Film film = arkiv.finnFilm(1);
        assertNotNull(film, "Film med nummer 1 skal finnes.");
        assertEquals("Jaws", film.getTittel(), "Forventet tittel 'Jaws'.");
    }
    
    @Test
    public void testSokTittel() {
        Film[] resultater = arkiv.soekTittel("Jaws");
        assertEquals(1, resultater.length, "Forventet 1 treff.");
        assertEquals("Jaws", resultater[0].getTittel(), "Forventet tittel 'Jaws'.");
    }
    
    @Test
    public void testSlettFilm() {
        boolean slettet = arkiv.slettFilm(1);
        assertTrue(slettet, "Forventet at film med nummer 1 ble slettet.");
        assertEquals(1, arkiv.antall(), "Forventet totalt 1 film etter sletting.");
    }

    @Test
    public void testAntallEtterSletting() {
        arkiv.leggTilFilm(new Film(3, "Test Regissør", "Test Film", 2023, "TestSelskap", Sjanger.ACTION));
        arkiv.slettFilm(3);
        assertEquals(2, arkiv.antall(), "Antallet filmer skal være korrekt oppdatert etter sletting.");
    }
}



