package datakontaktfirma;

public class Datakontakt {

	private static Medlem[] medlemmer;
	private static int antallmedlemmer;
	
	
	public Datakontakt(int antall) {
		medlemmer = new Medlem[antall];
		antallmedlemmer = 0;
	}
	
	public static void leggTilMedlem(Medlem person) {
		
		medlemmer[antallmedlemmer] = person;
		antallmedlemmer++;
		
	}
//	som finner indeksen til medlemmet i medlemstabellen dersom medlemmet er registrert, 
//  ellers returneres indeks lik-1.(Noen vil kanskje si at vi denne metoden burde returnert en 
//  referanse slik at vi lettere kunne bytte ut til annen datastruktur, men det lar vi være) .
	public int finnMedlemsIndeks(String medlemsnavn) {
		
		for(int i = 0; i<antallmedlemmer; i++) {
			if(medlemmer[i].getNavn().equals(medlemsnavn)) {
				return i;
			}
		}
		return -1;
	}
//	som finner ut om et medlem (identifisert med medlemsnavn) passer med et annet medlem (dersom det finnes) 
//  i medlemstabellen. Dette medlemmet skal være det første som passer og ikke er “koblet”. Metoden oppdaterer 
//  medlemstabellen dersom det finner en partner, og returnerer eventuell indeks til partneren i medlemstabellen (eller-1).
	public int finnPartnerFor(String medlemsnavn) {
//		
		for(int i= 0; i<antallmedlemmer; i++) {
			if(medlemmer[i].passerTil(medlemmer[finnMedlemsIndeks(medlemsnavn)]) && medlemmer[i].getStatusIndeks() == -1 &&
					medlemmer[finnMedlemsIndeks(medlemsnavn)].getStatusIndeks() == -1 && !(medlemmer[i].getNavn().equals(medlemsnavn))) {
				
				medlemmer[i].setStatusIndeks(finnMedlemsIndeks(medlemsnavn));
				medlemmer[finnMedlemsIndeks(medlemsnavn)].setStatusIndeks(i);
				return i;
			} 
		}
		return -1;
	}
	
//  som oppdaterer medlemstabellen, slik at dette medlemmet (identifisert ved medlemsnavn) og dets partner, 
//  dersom det fins, ikke lenger er "koblet" (dvs. begge får statusindeks –1).
	public int tilbakestillStatusIndeks(String medlemsnavn) {
		
		for(int i= 0; i<antallmedlemmer; i++) {
			if(medlemmer[i].passerTil(medlemmer[finnMedlemsIndeks(medlemsnavn)]) && medlemmer[i].getStatusIndeks() != -1 &&
					medlemmer[finnMedlemsIndeks(medlemsnavn)].getStatusIndeks() != -1) {
				
				medlemmer[i].setStatusIndeks(-1);
				medlemmer[finnMedlemsIndeks(medlemsnavn)].setStatusIndeks(-1);
				return i;
			} 
		}
		return -1;
		
	}
	//skriver ut hobbylisten for et medlem
	public void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public void skrivParListe(Datakontakt arkiv) { //datakontakt som parameter 
		
		Medlem[] tab = arkiv.getTab();
		
		int count = 0;
		
		for(int i = 0; i < arkiv.getAntall() ;i++) {
			int partnerIndeks = tab[i].getStatusIndeks();
					if(partnerIndeks !=-1 && partnerIndeks > i) {
						count++;
			
				String match1 = tab[i].getNavn();
				String match2 = tab[partnerIndeks].getNavn();
				
				System.out.println("PARNAVN: " + "<" + match1 + ", " + match2 + ">     " + "HOBBYER: " + tab[i].getHobbyer().toString());	
					}
					
		}
		
		System.out.println("Antall Parliste: " + count);
	}
	
	public void skrivUtMedlemmer(Datakontakt arkiv) {
		
		int count = 0;
		System.out.println("Medlemsliste: ");
		
		for(int i = 0; i < arkiv.getAntall(); i++) {
			String medlem = arkiv.getTab()[i].getNavn();
			count++;
			
			System.out.println(medlem + arkiv.getTab()[i].getHobbyer().toString());
		}
		System.out.println("Antall medlemmer: " + count);
		
	}


	public Medlem[] getTab() {
		return medlemmer;
	}
	public int getAntall() {
		return antallmedlemmer;
	}
	
}
