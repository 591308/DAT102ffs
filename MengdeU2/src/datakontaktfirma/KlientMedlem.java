package datakontaktfirma;


public class KlientMedlem {

	public static void main(String[] args) {
		
		Datakontakt dataKontakt = new Datakontakt(20);

		Meny meny = new Meny(dataKontakt);

		meny.start();
		
//		Hobby game = new Hobby("game");
//		Hobby sove = new Hobby("sove");
//		Hobby syngje = new Hobby("syngje");
//		Hobby danse = new Hobby("danse");
//		
//		KjedetMengde<Hobby> karstenS = new KjedetMengde<Hobby>();
//			karstenS.leggTil(game);
//			karstenS.leggTil(sove);
//		
//		KjedetMengde<Hobby> eivydasS = new KjedetMengde<Hobby>();
//			eivydasS.leggTil(sove);
//			eivydasS.leggTil(syngje);
//		
//		KjedetMengde<Hobby> ulrikS = new KjedetMengde<Hobby>();
//			ulrikS.leggTil(danse);
//			ulrikS.leggTil(sove);
//		
//		KjedetMengde<Hobby> haralS = new KjedetMengde<Hobby>();
//			haralS.leggTil(sove);
//			haralS.leggTil(syngje);
//			
//		KjedetMengde<Hobby> annaS = new KjedetMengde<Hobby>();
//			annaS.leggTil(danse);
//			annaS.leggTil(sove);
//			
//		Medlem Karsten = new Medlem("Karsten", karstenS);
//		Medlem Eivydas = new Medlem("Eivydas", eivydasS);
//		Medlem Ulrik = new Medlem("Ulrik", ulrikS);
//		Medlem Haral = new Medlem("Haral", haralS);
//		Medlem Anna = new Medlem("Anna", annaS);
//		
//		Datakontakt dataKontakt = new Datakontakt(5);
//		
//		dataKontakt.leggTilMedlem(Haral);
//		dataKontakt.leggTilMedlem(Ulrik);
//		dataKontakt.leggTilMedlem(Eivydas);
//		dataKontakt.leggTilMedlem(Karsten);
//		dataKontakt.leggTilMedlem(Anna);
//		
//		System.out.println("Medlemmer: " + "\n");
//		System.out.println(Haral.toString());
//		System.out.println(Ulrik.toString());
//		System.out.println(Eivydas.toString());
//		System.out.println(Karsten.toString());
//		System.out.println(Anna.toString() + "\n");
//		
//		System.out.println("##############################################");
//		System.out.println("Finner index til medlemmer: ");
//		System.out.println("Haral sin index: " + dataKontakt.finnMedlemsIndeks("Haral"));
//		System.out.println("Ulrik sin index: " + dataKontakt.finnMedlemsIndeks("Ulrik"));
//		System.out.println("Eivydas sin index: " + dataKontakt.finnMedlemsIndeks("Eivydas"));
//		System.out.println("Karsten sin index: " + dataKontakt.finnMedlemsIndeks("Karsten"));
//		System.out.println("Anna sin index: " + dataKontakt.finnMedlemsIndeks("Anna") + "\n");
//		
//		System.out.println("##############################################");
//		System.out.println("Finner partner til Eivydas");
//		System.out.println(dataKontakt.finnPartnerFor("Eivydas"));
//	
//		System.out.println("Finner partner til Anna");
//		System.out.println(dataKontakt.finnPartnerFor("Ulrik"));
//		
//		System.out.println("Finner partner til Karsten");
//		System.out.println(dataKontakt.finnPartnerFor("Karsten"));
//		
//		System.out.println("##############################################");
//		System.out.println("Index på medlemmer i datakontakt");
//		System.out.println("Haral sin index: " + dataKontakt.finnMedlemsIndeks("Haral"));
//		System.out.println("Eivydas sin index: " + dataKontakt.finnMedlemsIndeks("Eivydas"));
//		
//		System.out.println("##############################################");
//		System.out.println("StatusIndeks til medlemmer: ");
//		System.out.println("Haral sin index: " + Haral.getStatusIndeks());
//		System.out.println("Eivydas sin index: " + Eivydas.getStatusIndeks());
//	
//		System.out.println("##############################################");
//		Datakontakt.skrivParListe(dataKontakt);
//		
//		System.out.println("##############################################");
//		System.out.println("TilbakestilleIndeks til Eivydas og Haral: " + dataKontakt.tilbakestillStatusIndeks("Haral") + ", " +  dataKontakt.tilbakestillStatusIndeks("Eivydas"));
//		System.out.println("Status Index til Eivas og Haral etter tilbakestilling " + Haral.getStatusIndeks() + ", " + Eivydas.getStatusIndeks());
//		Datakontakt.skrivParListe(dataKontakt);
//		
//		System.out.println("##############################################");
//		System.out.println("Tester union, snitt og differens: ");
//		System.out.println("Union av Haral og Ulrik:     " + Haral.getHobbyer().union(Ulrik.getHobbyer()));
//		System.out.println("Snitt av Haral og Ulrik:     " + Haral.getHobbyer().snitt(Ulrik.getHobbyer()));
//		System.out.println("Differens av Haral og Ulrik: " + Haral.getHobbyer().differens(Ulrik.getHobbyer()));
		
	}
	
}
