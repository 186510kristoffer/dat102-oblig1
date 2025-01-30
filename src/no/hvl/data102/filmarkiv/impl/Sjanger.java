package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
	    ACTION, DRAMA, HISTORY, SCIFI, SCIENCE_FICTION, FANTASY;

	    public static Sjanger finnSjanger(String navn) {
	        for (Sjanger s : Sjanger.values()) {
	            if (s.toString().toUpperCase().equalsIgnoreCase(navn)) {
	                return s;
	            }
	        }
	        return null;
	    }
	}



