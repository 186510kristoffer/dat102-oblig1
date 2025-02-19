package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

	private int filmnr;
	private String filmSkaper;
	private String tittel;
	private int lansering;
	private String filmselskap;
	private Sjanger sjanger;

	public Film(int filmnr, String filmSkaper, String tittel, int lansering, String filmselskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.filmSkaper = filmSkaper;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselskap = filmselskap;
		this.sjanger = sjanger;
	}

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

	public String getRegissor() {
		return null;
	}

	public String getAar() {
		return null;
	}

	public String getProdusent() {
		return null;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselvskap() {
		return filmselskap;
	}


	public void setFilmselvskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	@Override
	public String toString() {
		return "Film [filmnr=" + filmnr + ", filmSkaper=" + filmSkaper + ", tittel=" + tittel + ", lansering="
				+ lansering + ", filmselskap=" + filmselskap + ", sjanger=" + sjanger + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmSkaper, filmnr, filmselskap, lansering, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(filmSkaper, other.filmSkaper) && filmnr == other.filmnr
				&& Objects.equals(filmselskap, other.filmselskap) && lansering == other.lansering
				&& Objects.equals(tittel, other.tittel);
	}

}

