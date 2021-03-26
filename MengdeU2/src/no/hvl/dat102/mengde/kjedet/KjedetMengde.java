package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		
		LinearNode<T> aktuell = start.getNeste();
		LinearNode<T> forgjenger = start;
	
		T resultat = null;
		
		if(element.equals(start)) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			for(int soek = 0; soek < antall && !funnet; soek++) {
				if(aktuell.getElement().equals(element)) {
					funnet = true;
				} else {
					forgjenger = forgjenger.getNeste();
					aktuell = forgjenger.getNeste();
				}
			} if(funnet) {
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
				antall--;
			}
		}
		return resultat;
	}//

	
	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object ny) {

			@SuppressWarnings("unchecked")
			MengdeADT<T> m2 = (KjedetMengde<T>)ny;
			
			if (this.antall != m2.antall()) {
				return false;
			} else {
				Iterator<T> teller = m2.oppramser();
				while(teller.hasNext()) {
					if(!(inneholder(teller.next()))){
						return false;
					}
				}
			}
		return true;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element;
		
		KjedetMengde<T> par = ((KjedetMengde<T>)begge);
		
		while(aktuell!=null) {
			
			par.settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
			Iterator<T> teller = m2.oppramser();
			while(teller.hasNext()) {
				element = teller.next();
				if(!inneholder(element)) {
					par.settInn(element);
				}
				
			} 
			return begge;
		}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
	  
	        MengdeADT<T> snittM = new KjedetMengde<T>();
	        
	        LinearNode<T> aktuell = start;
	        T element;
	        
	        while (aktuell != null) {
	            element = aktuell.getElement();
	            if (m2.inneholder(element)) {
	                ((KjedetMengde<T>) snittM).settInn(element);
	            }
	            aktuell = aktuell.getNeste();
	        }

	        return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		
		MengdeADT<T> differensM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element;
		
		KjedetMengde<T> pars = ((KjedetMengde<T>)differensM);
		
		while(aktuell!=null) {
			element = aktuell.getElement();	
			
			if(!m2.inneholder(element)) {
				pars.settInn(element);
			}
			aktuell = aktuell.getNeste();
			
		}
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean delmengde = true;
		
		Iterator<T> underMengde = m2.oppramser();
		T element;
		
		while(underMengde.hasNext() && delmengde) {
			element = underMengde.next();
			
			if(!this.inneholder(element)){
				delmengde = false; 
			}
		}
		return delmengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	public String toString(){
		String resultat = "";
		LinearNode<T> aktuell = start;
		
		while(aktuell != null){
			if(aktuell.getNeste() != null) {
				resultat += aktuell.getElement().toString() + ", ";
			} else {
				resultat += aktuell.getElement().toString();
			}
			
			aktuell = aktuell.getNeste();
			
			}return "<" + resultat + ">";
			
		}
	

}// class
