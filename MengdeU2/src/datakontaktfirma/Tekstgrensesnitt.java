package datakontaktfirma;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Tekstgrensesnitt {//Klasse for inn/ut terminal

	//leser opplysningene on met medlem fra tastatur
	public Medlem lesMedlem() {
		
		
		@SuppressWarnings("resource")
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Skriv inn medlemsnavn");
		String medlemsNavn = in.next();
		
		//System.out.println("Skriv inn antall hobbyer du vil legge til:");
		
		//KjedetMengde<Hobby> hobbysamling = new KjedetMengde<Hobby>();
		
		TabellMengde<Hobby> hobbysamling = new TabellMengde<Hobby>();
		
		nyHobbyer(hobbysamling);
//		String[] navn = new String [in.nextInt()];   
//		in.nextLine();
//		
//		KjedetMengde<Hobby> hobbysamling = new KjedetMengde<Hobby>();
//		
//		for (int i = 0; i < navn.length; i++){  
//			navn[i] = in.next();
//		}  
//		
//		for(String str: navn) {
//			Hobby hobbyNavn = new Hobby(str);
//			hobbysamling.leggTil(hobbyNavn);
//		}
		
		Medlem nyMedlem = new Medlem(medlemsNavn, hobbysamling);
		
		return nyMedlem;

	}
	
	public void nyHobbyer(MengdeADT<Hobby> hobbyer){
		
		Scanner inn = new Scanner(System.in);
		
		System.out.println("Skriv inn hobbyer, ferdig? Skriv, nei.");
		String str = inn.nextLine();
		
		if(!str.equals("nei")) {
			Hobby hobbyNavn = new Hobby(str);
			hobbyer.leggTil(hobbyNavn);
			nyHobbyer(hobbyer);
		}
		
		
	}
	
}
