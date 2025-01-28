package no.hvl.data102.filmarkiv.test;

import org.junit.jupiter.api.BeforeEach;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {

	private Filmarkiv2 arkiv;
	
	@BeforeEach
	public void setUp() {
		  
		arkiv = new Filmarkiv2();  

	    arkiv.leggTilFilm(new Film(1, "Spielberg", "Jaws", 1975, "Universal", Sjanger.ACTION));
	    arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, "Warner Bros", Sjanger.SCIFI));
  }

	
}
