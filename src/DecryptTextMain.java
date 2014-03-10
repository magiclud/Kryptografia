public class DecryptTextMain {
	public static void main(String[] args) {
		String hasloDoKeystora = "ala ma kota";
		String aliasHasla = "mojAlias";
		String sciezkaDoKeyStore = "D:\\eclipse\\Semestr4\\SzyfrStrumieniowy\\keyStore.ks";

		String wiadomosc = "between the hammer and the anvil.";
		byte[] kryptogram = RC4wersjaWlasciwa.zakoduj(wiadomosc,
				RC4wersjaWlasciwa.pobierzKlucz(sciezkaDoKeyStore, aliasHasla, hasloDoKeystora));
		RC4wersjaWlasciwa.zapiszZakodowanaWiadomoscDoPilku(kryptogram);
		
		String wiadomosc2 = "nobody was hurt in the incident.";
		byte[] kryptogram2 = RC4wersjaWlasciwa.zakoduj(wiadomosc2,
				RC4wersjaWlasciwa.pobierzKlucz(sciezkaDoKeyStore, aliasHasla, hasloDoKeystora));
	
//		System.out.println(wiadomosc);
//		System.out.println(new String(kryptogram));
//		System.out.println(wiadomosc2);
//		System.out.println(new String(kryptogram2)); 
	
	//	System.out.println("Xor kryptogramow:    ");
		byte[] xorKryptogramow = DecryptText.wykonajXor(kryptogram, kryptogram2);
	//	DecryptText.wyswietlenie(xorKryptogramow);
		System.out.println("");
		
		/*tablice najczesciej wystepujacych liter*/
		byte[] tablicaE = new byte[xorKryptogramow.length];
		
		for(int i =0; i<xorKryptogramow.length;i++){
			tablicaE[i]='e';
		}
		System.out.println("tablicaE: " + new String(tablicaE));
		
			byte[] xorXorIWyrazenie2 = DecryptText.wykonajXor(xorKryptogramow, tablicaE );
			System.out.println("Wartosc xora (xorKryptogramow i tablicyLiterE):    " + new String (xorXorIWyrazenie2) );
}
}
