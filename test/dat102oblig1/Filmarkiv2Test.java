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

}

