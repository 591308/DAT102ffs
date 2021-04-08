package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.Random;

import no.hvl.dat102.KjedetBSTre;

public class KlientBSTre {
	/**
	 * @param args
	 */
	public static <T> void main(String[] args) {
		
		int antall = 100;
		int tall = 1023;
		
	
		ArrayList<KjedetBSTre<Integer>> list = arrayList(antall, tall);

		
		//minimumhoyde teoretisk
			double b =0;
			for(int i = 0; i < list.size(); i++) {
				b += list.get(i).minimumHoyde();
			}
			
			double a = b/antall;
			double c = a/(log2(tall));
			
			System.out.println("Antall noder n: " + tall);
			System.out.println("Minimal teoretisk hoyde for n elementer: " + c*log2(tall));
		
		//maksimalhoyde teoretisk
			double p = 0;
			for(int i = 0; i<list.size(); i++) {
				p += list.get(i).maksimalHoyde();
			}
			double m = p/antall;
			double c1 = m/(log2(tall));
			System.out.println("Maksimale teoretisk hoyde for n elementer: " + c1*log2(tall));
		
		//Minste hoyde i løpet av kjøringane
			int minHoyde = 0;
			int minHoyde2 = 0;
			int hoydeMin = 0;
			for(int i = 0; i <list.size(); i++) {
				for(int j = i+1; j < list.size(); j++) {
					minHoyde = list.get(i).minimumHoyde();
					minHoyde2 = list.get(j).minimumHoyde();
					
					if(minHoyde < minHoyde2) {
						hoydeMin = minHoyde;
					} else if (minHoyde > minHoyde2){
						hoydeMin = minHoyde2;
					}
				}
			}
		System.out.println("Minste hoyde i løpet av kjøringane: " + hoydeMin);
		
		//største hoyde  i løpet av kjøringane
		int stHoyde = 0;
		int stHoyde2 = 0;
		int hoydeSt = 0;
		for(int i = 0; i <list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				stHoyde = list.get(i).maksimalHoyde();
				stHoyde2 = list.get(j).maksimalHoyde();
				
				if(stHoyde > stHoyde2) {
					hoydeSt = stHoyde;
				} else if (stHoyde < stHoyde2){
					hoydeSt = stHoyde2;
				}
			}
		}
		System.out.println("Største hoyde i løpet av kjøringane: " + hoydeSt);
		
		//Gjennomsnittleg hoyde av alle kjøringane
		double alleKjoringane = (a + m)/2;
		System.out.println("Gjennomsnittleg høyde av alle kjøringane: " + Math.round(alleKjoringane));
		
		KjedetBSTre<Integer> bstre;
		double z = 0;
		for(int i = 0; i<antall;i++) {
			bstre = randomBinarTreGenerator(1024);
			z += bstre.hoyde();
		}
		
		double k = (z/antall)/(log2(tall));
		
		System.out.println("Teoretisk hoyde av 8192 elementer: " + Math.round(k*log2(8192)));
		KjedetBSTre<Integer> bs = randomBinarTreGenerator(8192);
		System.out.println("Faktiske hoyde av binaertre med 8192 elementer: " + bs.hoyde());
		
	
//		System.out.println("Legger til 5 elementer og fjerner den minste 2 gonga: ");
//		KjedetBSTre<Integer> bst = new KjedetBSTre<>();
//		
//		bst.leggTil(3); bst.leggTil(4); bst.leggTil(2); bst.leggTil(1); bst.leggTil(5);
//		bst.visInorden();
//		bst.fjernMin();
//		bst.visInorden();
//		bst.fjernMin();
//		bst.visInorden();
//		
//		System.out.println("Legger til elementer og skriver dem ut rekursivt mellom to grense verdier:");
//		KjedetBSTre<Integer> bstr = new KjedetBSTre<>();
//		bstr.leggTil(1); bstr.leggTil(5); bstr.leggTil(11); bstr.leggTil(4); bstr.leggTil(8); bstr.leggTil(11); bstr.leggTil(2);
//		bstr.skrivVerdier(0, 20);
	}
	
	public static KjedetBSTre<Integer> randomBinarTreGenerator(Integer n){
		
		Random random = new Random();
		KjedetBSTre<Integer> bstr = new KjedetBSTre<>();
		
		for(int i = 0; i < n; i++) {
			int tall = random.nextInt(n);
			bstr.leggTil(tall);
		}
		return bstr;	
	}	
	
	public static ArrayList<KjedetBSTre<Integer>> arrayList(int antall, int tall) {
		
		ArrayList<KjedetBSTre<Integer>> tr = new ArrayList<KjedetBSTre<Integer>>(); 
	
		for(int i = 0; i<antall;i++) {
			KjedetBSTre<Integer> bultre= randomBinarTreGenerator(tall);
			tr.add(bultre);
		}
		return tr;
	}
	
	public static int log2(int x){
	    return (int) (Math.log(x) / Math.log(2));
	}
	
}
