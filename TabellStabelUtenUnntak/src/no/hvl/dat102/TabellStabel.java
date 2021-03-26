package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;

/**
 * Tabellimplementasjon av en stabel.
 * 
 * @param <T> elementtypen
 */
public class TabellStabel<T> implements StabelADT<T> {
    private final static int STDK = 100;
    private int topp; // indikerer neste plass
    private T[] stabel;

    /*
     * Oppretter en tom stabel.
     */
    public TabellStabel() {
        this(STDK);
    }

    /**
     * Oppretter en tom stabel med en spesifisert kapasitet.
     * 
     * @param initiell kapasitet
     */
    public TabellStabel(int startKapasitet) {
        topp = 0;
        stabel = (T[]) (new Object[startKapasitet]);
    }

    /**
     * Legger til det spesifiserte elementet p� toppen av stabelen, utvider kapasitetet til stabelen hvis n�dvendig.
     * 
     * @param element
     */
    @Override
    public void push(T element) {
        if (antall() == stabel.length) {
            utvid();
        }

        stabel[topp] = element;
        topp++;
    }

    /**
     * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen er tom fra f�r, s� returneres null
     * 
     * @return elementet som tas av 
     */
    @Override
    public T pop() {
        T resultat = null;
        if (!erTom()) {
            resultat = stabel[topp - 1];
            topp--;
            stabel[topp] = null;
        }
        return resultat;
    }

    /**
     * Returnerer toppelementet uten � fjerne det.. Hvis stabelen er tom fra f�r, s� returneres null
     * 
     * @return toppelementet
     */
    @Override
    public T peek() {
        T resultat = null;
        if (!erTom()) {
            resultat = stabel[topp - 1];
        }

        return resultat;
    }

    /**
     * Returnerer sann hvis stabelen er tom og usann ellers.
     * 
     * @return sann hvis tom stabel
     */
    @Override
    public boolean erTom() {
        return topp == 0;
    }

    /**
     * Returnerer antall elementer.
     * 
     * @return antall elementer p� stabelen
     */
    @Override
    public int antall() {
        return topp;
    }

    /**
     * Returns en strengrepresentasjon av stabelen..
     * 
     * @return stremgrepresentasjon
     */
    @Override
    public String toString() {
        String resultat = "";

        for (int sok = 0; sok < topp; sok++) {
            resultat = resultat + stabel[sok].toString() + "\n";
        }

        return resultat;
    }

    /**
     * Oppretter en ny tabell for � lagre innholdet.
     */
    private void utvid() {
        T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

        for (int indeks = 0; indeks < stabel.length; indeks++) {
            hjelpeTabell[indeks] = stabel[indeks];
        }

        stabel = hjelpeTabell;
    }
}
