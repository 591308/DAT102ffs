package datakontaktfirma;

import java.util.Scanner;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private Datakontakt datakontakt;
	

	public Meny(Datakontakt datakontakt) {
		
		tekstgr = new Tekstgrensesnitt();
		this.datakontakt = datakontakt;
		
	}

	public void start() {
		
		System.out.println("Legg til medlem velg 1: ");
		System.out.println("Vis medlemmer i Datakontakt, velg 2:");
		System.out.println("Finn partner, velg 3");
		System.out.println("Tilbakestillpartnera, velg 4:");
		
		Scanner in = new Scanner(System.in);
		
		int valg = in.nextInt();
		
		switch(valg) {
		case 1:
			
			Datakontakt.leggTilMedlem(tekstgr.lesMedlem());
			
			start();
		
			break;
		case 2: 
			
			datakontakt.skrivUtMedlemmer(datakontakt);
			
			start();
			break;
		case 3:
			
			System.out.println("Skriv namn på medlem du vil finne partner til: ");
			String navn = in.next();
			datakontakt.finnPartnerFor(navn);
			
			datakontakt.skrivParListe(datakontakt);
			
			start();
			break;
			
		case 4:
			
			System.out.println("Skriv namn på medlem du vil tilbakestille: ");
			String navnet = in.next();
			datakontakt.tilbakestillStatusIndeks(navnet);
			datakontakt.skrivParListe(datakontakt);
			
			start();
			break;
			
		default:
			
			in.close();
		}
	}

}
