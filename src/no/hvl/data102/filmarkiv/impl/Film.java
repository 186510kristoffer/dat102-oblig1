package no.hvl.data102.filmarkiv.impl;

public class Film {

	private int filmnr;
	private String filmSkaper;
	private String tittel;
	private int lansering;
	private String filmselvskap;
	
	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmSkaper() {
		return filmSkaper;
	}

	public void setFilmSkaper(String filmSkaper) {
		this.filmSkaper = filmSkaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansering() {
		return lansering;
	}

	public void setLansering(int lansering) {
		this.lansering = lansering;
	}

	public String getFilmselvskap() {
		return filmselvskap;
	}

	public void setFilmselvskap(String filmselvskap) {
		this.filmselvskap = filmselvskap;
	}

	public Film(int filmnr, String filmSkaper, String tittel, int lansering, String filmselvskap) {
		super();
		this.filmnr = filmnr;
		this.filmSkaper = filmSkaper;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselvskap = filmselvskap;
	}
	
}
