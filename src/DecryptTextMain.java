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
	
		String mozliweWyrazenie ="the";
		byte[] kryptogramWyrazenia = RC4wersjaWlasciwa.zakoduj(mozliweWyrazenie,
				RC4wersjaWlasciwa.pobierzKlucz(sciezkaDoKeyStore, aliasHasla, hasloDoKeystora));
	
		System.out.println(wiadomosc);
		System.out.println(new String(kryptogram));
		System.out.println(wiadomosc2);
		System.out.println(new String(kryptogram2)); 
		System.out.println(mozliweWyrazenie);
		System.out.println(new String(kryptogramWyrazenia));
		
		System.out.println("Xor tekstow jawnych: ");
		DecryptText.wyswietlenie(DecryptText.wykonajXor(wiadomosc.getBytes(), wiadomosc2.getBytes()));
		//System.out.println("Wartosc hex: "+ RC4wersjaWlasciwa.ToHex(kryptogram));
		System.out.println("Xor kryptogramow:    ");
		DecryptText.wyswietlenie(DecryptText.wykonajXor(kryptogram, kryptogram2));
		System.out.println("");
		System.out.println("Xor kryptogramu1 i litery:    ");
		DecryptText.wyswietlenie(DecryptText.wykonajXor(kryptogram, kryptogramWyrazenia));
		System.out.println("Wartosc tego xora:    "  );
//		System.out.println("Wartosc hex: "+ DecryptText.zapisHex(kryptogram));
//		System.out.println("Wartosc hex: "+ DecryptText.zapisHex(kryptogram2));
		
	
		}
}
