package no.dat102.adt;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;

public class SirkulaerKoeTest extends KoeADTTest{
	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}		
}
