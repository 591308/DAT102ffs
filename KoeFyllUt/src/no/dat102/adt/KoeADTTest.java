package no.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/*
 * Test for KoeADT
 * @author 
 */
public abstract class KoeADTTest {
	/*
	 * Størrelse på koe
	 */
	
	// koe
	private KoeADT<Integer> koe;
	//Test data
	private Integer e0= 1;
	private Integer e1= 2;
	private Integer e2= 3;
	private Integer e3= 4;
	
	
	protected abstract KoeADT<Integer> reset();
	//Hent ny koe for hver test
	
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	
	//Sjekk at koe er tom
	@Test
	public void sjekkOmKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	//Test om koeInn og koeUt
	@Test 
	public void sjekkInnOgUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
	} catch(EmptyCollectionException e) {
		fail("utKoe feilet " + e.getMessage());
	}
}
	/**
	 * Test p� st�rrelsen
	 */
	@Test
	public void storrelse() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}
	
	@Test 
	public void denFoerste() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(1, koe.foerste());
	}
	
	
	@Test
	public void innKoeutKoeinnKoeinnKoeutKoeFoerste() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			koe.innKoe(e2);
			koe.innKoe(e3);
			koe.utKoe();
			assertEquals(e3, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("pop or top failed unexpectedly " + e.getMessage());
		}
	}
	
	@Test
	public void popFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}
