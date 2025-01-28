package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	
	
	public Film lesFilm(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Skriv inn filmens nummer: ");
	    int nr = scanner.nextInt();
	    scanner.nextLine();  
	    
	    System.out.print("Skriv inn filmens regissør: ");
	    String regissor = scanner.nextLine();
	    
	    System.out.print("Skriv inn filmens tittel: ");
	    String tittel = scanner.nextLine();
	    
	    System.out.print("Skriv inn produksjonsår: ");
	    int ar = scanner.nextInt();
	    
	    System.out.print("Skriv inn filmens sjanger (1 - ACTION, 2 - DRAMA, etc.): ");
	    int sjangerInput = scanner.nextInt();
	    Sjanger sjanger = Sjanger.values()[sjangerInput - 1]; 
	    
	    scanner.nextLine(); 
	    
	    System.out.print("Skriv inn filmens produsent: ");
	    String produsent = scanner.nextLine();
	    
	    return new Film(nr, regissor, tittel, ar, produsent, sjanger);
	}
		
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnummer: " + film.getFilmnr());
	    System.out.println("Tittel: " + film.getTittel());
	    System.out.println("Regissør: " + film.getFilmSkaper());
	    System.out.println("År: " + film.getLansering());
	    System.out.println("Sjanger: " + film.getSjanger().toString());
	    System.out.println("Produsent: " + film.getFilmSkaper());
	    System.out.println("----------------------------------");
	}
		

	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
	    Film[] filmer = arkiv.soekTittel(delstreng); 
	    if (filmer == null || filmer.length == 0) {
	        System.out.println("Ingen filmer funnet med tittelen som inneholder: " + delstreng);
	    } else {
	        for (Film film : filmer) {
	            skrivUtFilm(film); 
	        }
	    }
	}

	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
	    Film[] filmer = arkiv.soekProdusent(delstreng); 
	    if (filmer == null || filmer.length == 0) {
	        System.out.println("Ingen filmer funnet med produsent som inneholder: " + delstreng);
	    } else {
	        for (Film film : filmer) {
	            skrivUtFilm(film); 
	        }
	    }
	}
		    
	
	
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		 System.out.println("Totalt antall filmer: " + arkiv.antall());  
		 for (Sjanger sjanger : Sjanger.values()) {
		        int antall = arkiv.antall(sjanger);  
		        System.out.println("Antall filmer i sjanger " + sjanger + ": " + antall);
		    }
		}

	public void visFilmArkiv(FilmarkivADT filmarkiv) {
		
		
	}
	}
	
	

