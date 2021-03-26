package no.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class MengdeADTTest {

	private int en = 1;
	private int to = 2;
	private int tre = 3;
	private int fire = 4;
	
	
	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> fasit;
	
	protected abstract MengdeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		mengde1 = reset();
		mengde2 = reset();
		fasit = reset();
	}
	@Test
	public void sjekkerOmTom() {
		assertTrue(mengde1.erTom());
	}
	
	@Test
	public void union() {
		
		mengde1.leggTil(en);
		mengde1.leggTil(to);
		mengde2.leggTil(en);
		mengde2.leggTil(to);
		
		fasit.leggTil(en);
		fasit.leggTil(to);
		
		assertEquals(fasit, mengde1.union(mengde2));
		
	}
	@Test 
	public void unionDisjunkte() {
		mengde1.leggTil(en);
		mengde1.leggTil(to);
		
		mengde2.leggTil(tre);
		mengde2.leggTil(fire);
		
		fasit.leggTil(en);
		fasit.leggTil(to);
		fasit.leggTil(tre);
		fasit.leggTil(fire);
	
		assertEquals(fasit, mengde1.union(mengde2));
	}
	@Test
	public void snitt() {
		
		mengde1.leggTil(en);
        mengde1.leggTil(to);
        mengde1.leggTil(tre);
        mengde1.leggTil(fire);
        
        mengde2.leggTil(tre);
        mengde2.leggTil(fire);
       
        
        fasit.leggTil(tre);
        fasit.leggTil(fire);
        
        assertEquals(fasit, mengde1.snitt(mengde2));
	}
	@Test
	public void snittDisjunkte() {
		mengde1.leggTil(en);
        mengde1.leggTil(to);
        
        mengde2.leggTil(tre);
        mengde2.leggTil(fire);
        
        fasit.erTom();
       
        assertEquals(fasit, mengde1.snitt(mengde2));
	}
	
	@Test
    public void differanse() {
		mengde1.leggTil(en);
        mengde1.leggTil(to);
        mengde1.leggTil(tre);
        mengde1.leggTil(fire);
        
        mengde2.leggTil(tre);
        mengde2.leggTil(fire);
        
        fasit.leggTil(en);
        fasit.leggTil(to);
        
        assertEquals(fasit, mengde1.differens(mengde2));
 }
	@Test
	public void differanseDisjunkte() {
		mengde1.leggTil(en);
        mengde1.leggTil(to);
        
        mengde2.leggTil(tre);
        mengde2.leggTil(fire);
        
        fasit.leggTil(en);
        fasit.leggTil(to);
        
        assertEquals(fasit, mengde1.differens(mengde2));
	}
 
	@Test
    public void delmengde() {
	 	mengde1.leggTil(en);
        mengde1.leggTil(to);
        mengde1.leggTil(tre);
        mengde1.leggTil(fire);
        
        mengde2.leggTil(tre);
        mengde2.leggTil(fire);
        
        assertTrue(mengde1.undermengde(mengde2));
 }
	
 @Test
 public void utskrift() {
	 	mengde1.leggTil(en);
	 	mengde1.leggTil(to);
	 	mengde1.leggTil(tre);
	 	mengde1.leggTil(fire);
     
	 	mengde2.leggTil(tre);
	 	mengde2.leggTil(fire);
     
	 	System.out.println("Tabell 1: " + mengde1.toString() + "\n");
     
	 	System.out.println("Tabell 2: " + mengde2.toString() + "\n");
 	}
}
