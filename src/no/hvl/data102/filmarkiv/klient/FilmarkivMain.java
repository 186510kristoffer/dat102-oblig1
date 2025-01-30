package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivMain {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        FilmarkivADT filmarkiv = new Filmarkiv(10); 
        Tekstgrensesnitt tg = new Tekstgrensesnitt();

   
        boolean fortsett = true;
        while (fortsett) {
            System.out.println("\n Filmarkiv - Velg en operasjon:");
            System.out.println("1 - Legg til en ny film");
            System.out.println("2 - Finn en film etter nummer");
            System.out.println("3 - Slett en film");
            System.out.println("4 - Søk etter filmer etter tittel");
            System.out.println("5 - Søk etter filmer etter produsent");
            System.out.println("6 - Se antall filmer i en sjanger");
            System.out.println("7 - Vis alle filmer");
            System.out.println("8 - Avslutt programmet");
            System.out.print("Velg et alternativ (1-8): ");
            System.out.println(); 
            
            int valg = -1; 
            
           
            while (!scanner.hasNextInt()) {
                System.out.println("Feil: Du må skrive et gyldig tall! Prøv igjen...");
                scanner.nextLine(); 
                System.out.print("Velg et alternativ (1-8): ");
            }

            valg = scanner.nextInt();
            scanner.nextLine(); 

            switch (valg) {
                case 1: 
                    System.out.print("\nHvor mange filmer vil du legge til? ");
                    int antallFilmer = scanner.nextInt();
                    scanner.nextLine(); 
                    for (int i = 0; i < antallFilmer; i++) {
                        System.out.println("\nLegg til film nr. " + (i + 1));
                        filmarkiv.leggTilFilm(tg.lesFilm());
                    }
                    break;

                case 2: 
                    System.out.print("\nSkriv inn filmnummeret du vil finne: ");
                    int filmnr = scanner.nextInt();
                    scanner.nextLine();
                    Film film = filmarkiv.finnFilm(filmnr);
                    if (film != null) {
                        tg.skrivUtFilm(film);
                    } else {
                        System.out.println("Fant ingen film med nummer: " + filmnr);
                    }
                    break;

                case 3: 
                    System.out.print("\nSkriv inn filmnummeret du vil slette: ");
                    int slettNr = scanner.nextInt();
                    scanner.nextLine();
                    boolean slettet = filmarkiv.slettFilm(slettNr);
                    if (slettet) {
                        System.out.println("Film med nummer " + slettNr + " ble slettet.");
                    } else {
                        System.out.println("Fant ikke film med nummer: " + slettNr);
                    }
                    break;

                case 4: 
                    System.out.print("\nSkriv inn tittel eller del av tittel du vil søke etter: ");
                    String tittel = scanner.nextLine();
                    tg.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
                    break;

                case 5: 
                    System.out.print("\nSkriv inn produsent eller del av produsent du vil søke etter: ");
                    String produsent = scanner.nextLine();
                    tg.skrivUtFilmProdusent(filmarkiv, produsent);
                    break;

                case 6: 
                    System.out.println("\nVelg en sjanger:");
                    for (Sjanger s : Sjanger.values()) {
                        System.out.println((s.ordinal() + 1) + " - " + s);
                    }
                    System.out.print("Velg sjanger (1-" + Sjanger.values().length + "): ");
                    int sjangerValg = scanner.nextInt();
                    scanner.nextLine();
                    if (sjangerValg >= 1 && sjangerValg <= Sjanger.values().length) {
                        Sjanger valgtSjanger = Sjanger.values()[sjangerValg - 1];
                        int antall = filmarkiv.antall(valgtSjanger);
                        System.out.println("Antall filmer i sjangeren " + valgtSjanger + ": " + antall);
                    } else {
                        System.out.println("Ugyldig sjanger.");
                    }
                    break;

                case 7: 
                    tg.skrivUtFilmDelstrengITittel(filmarkiv, "");
                    break;

                case 8:
                    System.out.println("Avslutter programmet...");
                    fortsett = false;
                    break;

                default:
                    System.out.println("Ugyldig valg, prøv igjen.");
            }
        }

        scanner.close();
    }
}
