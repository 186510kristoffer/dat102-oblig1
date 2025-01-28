package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2(int antall, LinearNode<Film> start) {
        this.antall = antall;
        this.start = start;
    }

    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;
        while(aktuell != start) {
        	if(aktuell.data.getFilmnr() == nr) {
        		return aktuell.data;
        	}
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;

    }

    @Override
    public boolean slettFilm(int filmnr) {

    	LinearNode<Film> forrige = null;
        LinearNode<Film> aktuell = start;
        
        while(aktuell != null) {
        	if(aktuell.data.getFilmnr() == filmnr) {
        		if(forrige == null) {
        			start = aktuell.neste;
        		} else {
        			forrige.neste = aktuell.neste;
        		}
        		antall--;
        		return true;
        	}
        	forrige = aktuell;
        	aktuell = aktuell.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

    	LinearNode<Film> aktuell = start;
        Film[] resultat = new Film[antall];
        int teller = 0;
    	
        while(aktuell != null) {
        	if (aktuell.data.getTittel().contains(delstreng)) {
                resultat[teller++] = aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return trimTabell(resultat, teller);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

    	LinearNode<Film> aktuell = start;
        Film[] resultat = new Film[antall];
        int teller = 0;

        while (aktuell != null) {
            if (aktuell.data.getFilmSkaper().contains(delstreng)) {
                resultat[teller++] = aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return trimTabell(resultat, teller);
    }

    @Override
    public int antall(Sjanger sjanger) {

    	LinearNode<Film> aktuell = start;
        int teller = 0;

        while (aktuell != null) {
            if (aktuell.data.getSjanger() == sjanger) {
                teller++;
            }
            aktuell = aktuell.neste;
        }
        return teller;
    }

    @Override
    public int antall() {
        // TODO Auto-generated method stub
        return antall;
    }
    private Film[] trimTabell(Film[] tabell, int lengde) {
        Film[] nyTabell = new Film[lengde];
        for (int i = 0; i < lengde; i++) {
            nyTabell[i] = tabell[i];
        }
        return nyTabell;
    }

}
