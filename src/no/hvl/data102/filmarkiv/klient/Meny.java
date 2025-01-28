package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.*;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		leggTilEksempeldata();

		System.out.println("Viser alle filmer i arkivet:");
		tekstgr.visFilmArkiv(filmarkiv);

		System.out.println("\nSøker etter filmer med 'Jurassic' i tittelen:");
		tekstgr.skrivUtFilmerMedDelstrengITittel(filmarkiv, "Jurassic");

		System.out.println("\nSøker etter filmer av produsenten 'Quentin Tarantino':");
		tekstgr.skrivUtFilmerAvProdusent(filmarkiv, "Quentin Tarantino");

		System.out.println("\nAntall filmer i ACTION-sjangeren:");
		tekstgr.skrivUtStatistikk(filmarkiv);
	}

	private void leggTilEksempeldata() {
		filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
		filmarkiv.leggTilFilm(new Film(2, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax"));
		filmarkiv
				.leggTilFilm(new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures"));
		filmarkiv
				.leggTilFilm(new Film(4, "James Cameron", "Avatar", 2009, Sjanger.SCIENCE_FICTION, "20th Century Fox"));
		filmarkiv.leggTilFilm(
				new Film(5, "Peter Jackson", "The Lord of the Rings", 2001, Sjanger.FANTASY, "New Line Cinema"));
	}
}
