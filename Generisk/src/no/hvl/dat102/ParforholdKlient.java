package no.hvl.dat102;

public class ParforholdKlient {  
public static void main(String[] args) {
    Par<String> strPar = new Par<String>("Ole", "Kari");   
    Par<Integer> intPar = new Par<Integer>(2019, 2020);
    
    System.out.println(strPar);
    String maksStreng = strPar.maks();
    System.out.printf("st?rste %s%n",maksStreng);        
    //--------------------------------------
    System.out.println(intPar);
    int maksHeltall = intPar.maks();
    System.out.printf("st?rste %d%n",maksHeltall);      
  }
}

