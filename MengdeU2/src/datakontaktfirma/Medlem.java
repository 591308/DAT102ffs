package datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	
	private String navn;
	private MengdeADT<Hobby> hobbyer; 
	private int statusIndeks;
	

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		statusIndeks = -1;
		this.hobbyer = hobbyer;
	}
	
	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}
	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getStatusIndeks() {
		return statusIndeks;
	}
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	//som avgjør om to medlemmer passer tilhverandre og altså kan danne et par. 
	//To medlemmer passer til hverandre dersom de har nøyaktig samme hobbyer (tips:like mengder).
	public boolean passerTil(Medlem medlem2) {
		return this.getHobbyer().equals(medlem2.getHobbyer());
	}
	
	public String toString() {
		return navn + ": " + hobbyer;
	}
	
}
