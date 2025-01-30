package dat102oblig1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
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
        Film nyFilm = new Film(3, "Lucas", "Star Wars", 1977, "Fox", Sjanger.SCIFI);
        arkiv.leggTilFilm(nyFilm);
        assertEquals(3, arkiv.antall(), "Forventet antall filmer i arkivet skal være 3.");
        assertEquals("Star Wars", arkiv.finnFilm(3).getTittel(), "Tittelen skal være 'Star Wars'.");
    }

    
    @Test
    public void testFinnFilm() {
        Film film = arkiv.finnFilm(1);
        assertNotNull(film, "Film med nummer 1 skal finnes.");
        assertEquals("Jaws", film.getTittel(), "Tittelen skal være 'Jaws'.");
    }

    @Test
    public void testFinnFilmIkkeEksisterer() {
        Film film = arkiv.finnFilm(999);
        assertNull(film, "Film med nummer 999 skal ikke finnes.");
    }
    
    @Test
    public void testSlettFilm() {
        boolean slettet = arkiv.slettFilm(1);
        assertTrue(slettet, "Film med nummer 1 skal bli slettet.");
        assertEquals(1, arkiv.antall(), "Antall filmer skal være 1 etter sletting.");
    }

    @Test
    public void testSlettFilmIkkeEksisterer() {
        boolean slettet = arkiv.slettFilm(999);
        assertFalse(slettet, "Film med nummer 999 skal ikke finnes og ikke slettes.");
    }
    
    @Test
    public void testSokTittel() {
        Film[] resultater = arkiv.soekTittel("Jaws");
        assertEquals(1, resultater.length, "Forventet 1 film med tittelen som inneholder 'Jaws'.");
        assertEquals("Jaws", resultater[0].getTittel(), "Tittelen skal være 'Jaws'.");
    }

    @Test
    public void testSokTittelIngenMatch() {
        Film[] resultater = arkiv.soekTittel("IkkeEksisterende");
        assertEquals(0, resultater.length, "Forventet ingen filmer som matcher.");
    }
    
    @Test
    public void testSokProdusent() {
        Film[] resultater = arkiv.soekProdusent("Spielberg");
        assertEquals(1, resultater.length, "Forventet 1 film av produsenten 'Spielberg'.");
        assertEquals("Jaws", resultater[0].getTittel(), "Tittelen skal være 'Jaws'.");
    }

    @Test
    public void testSokProdusentIngenMatch() {
        Film[] resultater = arkiv.soekProdusent("IkkeEksisterende");
        assertEquals(0, resultater.length, "Forventet ingen filmer som matcher.");
    }
    
    @Test
    public void testAntall() {
        assertEquals(2, arkiv.antall(), "Forventet totalt 2 filmer i arkivet.");
    }

    @Test
    public void testAntallPerSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.ACTION), "Forventet 1 ACTION-film.");
        assertEquals(1, arkiv.antall(Sjanger.SCIFI), "Forventet 1 SCIFI-film.");
    }
    
    @Test
    public void testTomtArkiv() {
        Film[] resultater = arkiv.soekTittel("NoeSomIkkeFinnes");
        assertEquals(0, resultater.length, "Forventet ingen resultater i et tomt arkiv.");
    }
    
    @Test
    public void testUtvidKapasitet() {
        for (int i = 3; i <= 15; i++) {
            arkiv.leggTilFilm(new Film(i, "Regissør", "Film " + i, 2000 + i, "Filmselskap", Sjanger.ACTION));
        }
        assertEquals(15, arkiv.antall(), "Forventet 15 filmer etter utvidelse av kapasitet.");
    }
    
    @Test
    public void testAntallEtterLeggTil() {
        arkiv.leggTilFilm(new Film(3, "Cameron", "Avatar", 2009, "Fox", Sjanger.SCIFI));
        assertEquals(3, arkiv.antall(), "Forventet totalt 3 filmer i arkivet etter å legge til en ny film.");
    }

    @Test
    public void testAntallEtterSletting() {
        arkiv.slettFilm(1); // Sletter en film
        assertEquals(1, arkiv.antall(), "Forventet totalt 1 film i arkivet etter sletting.");
    }
    
 









}