package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

	private Film[]filmer;
	private int antall;
	
	
	public Filmarkiv(Film[] filmer, int antall) {
		this.filmer = filmer;
		this.antall = antall;
	}

	@Override
	public Film finnFilm(int nr) {
		
		for (int i = 0; i < antall; i++) {
			if(filmer[i].getFilmnr() == nr) {
				return filmer[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (antall == filmer.length) {
			filmer[antall] = nyFilm;
			antall++;
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmnr() == filmnr) {
				filmer[i] = filmer[antall-1];
				filmer[antall-1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] res = new Film[antall];
		int antallFunnet = 0;
		
		for (int i = 0; i < antall; i++) {
			if(filmer[i].getTittel().contains(delstreng)) {
				res[antallFunnet++] = filmer[i];
			}
		}
		return res;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] pro = new Film[antall];
		int antallFunnet = 0;
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmSkaper().contains(delstreng)) {
				pro[antallFunnet++] = filmer[i];
			}
		}
		
		return pro;
	}

	@Override
	public int antall(Sjanger sjanger) {

		int antallSjanger = 0;
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	private void utvidKapasitet() {
		
		Film[]dobletTabell = new Film[filmer.length * 2];
		
		for (int i = 0; i < antall; i++) {
			dobletTabell[i] = filmer[i];
		}
		filmer = dobletTabell;
		
	}

}





