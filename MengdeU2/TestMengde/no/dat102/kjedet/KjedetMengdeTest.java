package no.dat102.kjedet;

import no.dat102.adt.MengdeADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest extends MengdeADTTest {

	protected MengdeADT<Integer> reset(){
		return new KjedetMengde<Integer>();
	}
}
