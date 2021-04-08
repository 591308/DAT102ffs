package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;


//********************************************************************
// KjedetBin�rS�keTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt bin�rt s�ketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et bin�rt s�ketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	//hoyden for et tre
	public int hoyde() {
		return hoydeRek(rot);
	}
	
	private int hoydeRek(BinaerTreNode<T> t) {
		if(t == null) {
			return 0;
		}else {
		return 1 + Math.max(hoydeRek(t.getVenstre()),hoydeRek(t.getHoyre()));
		}
	}
	/**********************************************************************
	 * Legger det spesifiserte elementet p� passende plass i BS-treet. Like
	 * elementer blir lagt til h�yre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}
	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if(p == null) {
			return new BinaerTreNode<T>(element);
		}else {
			if(element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTilRek(p.getVenstre(), element));
			}else {
				p.setHoyre(leggTilRek(p.getHoyre(), element));
			}
			return p;
		}
	}
	//Metoden for å beregne minimal hoyde av et BSTre
	public int minimumHoyde() {
		return minimumHoyde(rot);
	}
	private int minimumHoyde(BinaerTreNode<T> t) {
	
        if (t == null)
            return 0;
 
        if (t.getVenstre() == null && t.getHoyre() == null)
            return 1;
 
        if (t.getVenstre() == null)
            return minimumHoyde(t.getHoyre()) + 1;
 
        if (t.getHoyre() == null)
            return minimumHoyde(t.getVenstre()) + 1;
 
        return Math.min(minimumHoyde(t.getVenstre()), minimumHoyde(t.getHoyre())) + 1;		
	}
	public int maksimalHoyde() {
		return maksimalHoyde(rot);
	}
	private int maksimalHoyde(BinaerTreNode<T> t) {
		if (t == null)
            return 0;
        else
        {
        	//beregne 
            int vHoyde = maksimalHoyde(t.getVenstre());
            int hHoyde = maksimalHoyde(t.getHoyre());
  
            /* use the larger one */
            if (vHoyde > hHoyde)
                return (vHoyde + 1);
             else
                return (hHoyde + 1);
        }
	}
	/******************************************************************
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// 
	}
	
	//Fjern
	/******************************************************************
	 * Fjerner noden med minste verdi fra dette bin�re s�ketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		T result = null;
		if(rot == null) {
			return null;
		} else {
			if(rot.getVenstre() == null) {
				result = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> parent = rot;
				BinaerTreNode<T> current = rot.getVenstre();
				while(current.getVenstre() != null) {
					parent = current;
					current = current.getVenstre();
				}
				result = current.getElement();
				parent.setVenstre(current.getHoyre());
			}
			antall--;
		}
		return result;
	}
	//
	/******************************************************************
	 * Fjerner noden med st�rste verdi fra dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		// TODO 
		return null;
	}
	/******************************************************************
	 * Returnerer det minste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		
		while(rot.getVenstre() !=null) {
			rot = rot.getVenstre();
		}
		return rot.getElement();
	}//

	/******************************************************************
	 * Returnerer det st�rste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		
		while(rot.getHoyre()!=null) {
			rot = rot.getHoyre();
		}
		return rot.getElement();
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		
		T svar = null;
		if(p != null) {
			int sml = element.compareTo(p.getElement());
			if(sml == 0) {
				svar = p.getElement();
			} else if(sml < 0) {
				svar = finnRek(element,p.getVenstre());
			}else if(sml > 0) {
				svar = finnRek(element, p.getHoyre());
			}
		}
		return svar;
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO 
		return null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
		
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void skrivVerdier(T nedre, T ovre){
		skrivVerdierRek(rot, nedre, ovre);
		}
	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks){ 
		if(t != null){   
			skrivVerdierRek(t.getVenstre(), min, maks);   
			if((t.getElement().compareTo(min) >= 0) &&(t.getElement().compareTo(maks) <=0)) {
				System.out.print(t.getElement() + " ");
				}
			skrivVerdierRek(t.getHoyre(), min, maks);
			}
	}
}// class
