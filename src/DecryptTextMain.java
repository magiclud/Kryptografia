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
		byte[] xorTekstowJawnych = DecryptText.wykonajXor(wiadomosc.getBytes(), wiadomosc2.getBytes());
		DecryptText.wyswietlenie(xorTekstowJawnych);
		//System.out.println("Wartosc hex: "+ DecryptText.zapisHex(kryptogram));
		//System.out.println("Wartosc hex: "+ DecryptText.zapisHex(kryptogram2));
		System.out.println("Xor kryptogramow:    ");
		DecryptText.wyswietlenie(DecryptText.wykonajXor(kryptogram, kryptogram2));
		System.out.println("");
		System.out.println("Xor (xora tekstow jawnych) i wyrazenia:    ");
		byte[] xorXorIWyrazenie = DecryptText.wykonajXor(xorTekstowJawnych, kryptogramWyrazenia);
		DecryptText.wyswietlenie(xorXorIWyrazenie);
		System.out.println("Wartosc tego xora:    " + new String (xorXorIWyrazenie) );

		int oIlePrzesuniecieKryptogramu = 9;
		System.out.println("Przesuniety kryptogram mozliwego wyrazenia o " + oIlePrzesuniecieKryptogramu);
		byte[] przesunieteWtrazenie = DecryptText.przeunicieElementowTablicy(kryptogramWyrazenia, xorTekstowJawnych.length, oIlePrzesuniecieKryptogramu);
		DecryptText.wyswietlenie(przesunieteWtrazenie);
		
		System.out.println("");
		System.out.println("Xor (xora tekstow jawnych) i wyrazenia:    ");
		byte[] xor2XorIWyrazenie = DecryptText.wykonajXor(xorTekstowJawnych, przesunieteWtrazenie);
		DecryptText.wyswietlenie(xor2XorIWyrazenie);
		System.out.println("Wartosc tego xora:    " + new String (xor2XorIWyrazenie) );
		
	
		}
}
