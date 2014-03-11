public class DecryptTextMain {
	public static void main(String[] args) {
		String hasloDoKeystora = "ala ma kota";
		String aliasHasla = "mojAlias";
		String sciezkaDoKeyStore = "D:\\eclipse\\Semestr4\\SzyfrStrumieniowy\\keyStore.ks";

		String wiadomosc = "krowawda rhwuwi hwqjqa adidabi ";
		byte[] kryptogram = RC4wersjaWlasciwa.zakoduj(wiadomosc,
				RC4wersjaWlasciwa.pobierzKlucz(sciezkaDoKeyStore, aliasHasla,
						hasloDoKeystora));
		RC4wersjaWlasciwa.zapiszZakodowanaWiadomoscDoPilku(kryptogram);

		String wiadomos2 = "pajacyk . hauihe aheuie bqi3qi";
		byte[] kryptogram2 = RC4wersjaWlasciwa.zakoduj(wiadomos2,
				RC4wersjaWlasciwa.pobierzKlucz(sciezkaDoKeyStore, aliasHasla,
						hasloDoKeystora));

		// System.out.println("Xor kryptogramow:    ");
		byte[] xorKryptogramow = DecryptText
				.wykonajXor(kryptogram, kryptogram2);

		String alfabet = "^[a-zA-Z.-,!()]+$";
		
		String[] wiadDoOdszyfrowania = Wiadomosci.wiadDoOdszyfrowania
				.split(" ");
		byte[] szukanaWiadomosc = DecryptText
				.wiadomoscWBajtach(wiadDoOdszyfrowania);

		String[] wiad1 = Wiadomosci.wiad1.split(" ");	
		byte[] wiadomosc1 = DecryptText
				.wiadomoscWBajtach(wiad1);
		String[] wiad2 = Wiadomosci.wiad2.split(" ");	
		byte[] wiadomosc2 = DecryptText
				.wiadomoscWBajtach(wiad2);
		String[] wiad3 = Wiadomosci.wiad3.split(" ");	
		byte[] wiadomosc3 = DecryptText
				.wiadomoscWBajtach(wiad3);
		String[] wiad4 = Wiadomosci.wiad4.split(" ");	
		byte[] wiadomosc4 = DecryptText
				.wiadomoscWBajtach(wiad4);
		String[] wiad5 = Wiadomosci.wiad5.split(" ");	
		byte[] wiadomosc5 = DecryptText
				.wiadomoscWBajtach(wiad5);
		

		/* tablice najczesciej wystepujacych liter */
		byte[] a_tab = new byte[wiadDoOdszyfrowania.length];
		for (int i = 0; i < wiadDoOdszyfrowania.length; i++) {
			a_tab[i] = 'a';
		}
		
		// System.out.println("Xor kryptogramow:    ");
		byte[] xorZWiad1 = DecryptText
				.wykonajXor(szukanaWiadomosc, wiadomosc1); // z pierwsza wiadomoscia
		byte[] xorZWiad2 = DecryptText
				.wykonajXor(szukanaWiadomosc, wiadomosc2); // z druga wiadomoscia
		byte[] xorZWiad3 = DecryptText
				.wykonajXor(szukanaWiadomosc, wiadomosc3); // z trzecia wiadomoscia
		byte[] xorZWiad4 = DecryptText
				.wykonajXor(szukanaWiadomosc, wiadomosc4); // z czwarta wiadomoscia
		byte[] xorZWiad5 = DecryptText
				.wykonajXor(szukanaWiadomosc, wiadomosc5); // z piata wiadomoscia
		
		byte[] xorXorITab_a = DecryptText.wykonajXor(xorZWiad1,
				a_tab);//xor (xor z 1 i tablica a 
		byte[] xorXor2Tab_a = DecryptText.wykonajXor(xorZWiad2,
				a_tab);//xor (xor z 2 i tablica a 
		byte[] xorXor3Tab_a = DecryptText.wykonajXor(xorZWiad3,
				a_tab);//xor (xor z 3 i tablica a 
		byte[] xorXor4Tab_a = DecryptText.wykonajXor(xorZWiad4,
				a_tab);//xor (xor z 4 i tablica a 
		byte[] xorXor5Tab_a = DecryptText.wykonajXor(xorZWiad5,
				a_tab);//xor (xor z 5 i tablica a 
		System.out
				.println("Wartosc xora (xorMessageZWiad1 i tablicyLiter_a):    "
						+ new String(xorXorITab_a));
		System.out
		.println("Wartosc xora (xorMessageZWiad2 i tablicyLiter_a):    "
				+ new String(xorXor2Tab_a));
		System.out
		.println("Wartosc xora (xorMessageZWiad3 i tablicyLiter_a):    "
				+ new String(xorXor3Tab_a));
		System.out
		.println("Wartosc xora (xorMessageZWiad4 i tablicyLiter_a):    "
				+ new String(xorXor4Tab_a));
		System.out
		.println("Wartosc xora (xorMessageZWiad5 i tablicyLiter_a):    "
				+ new String(xorXor5Tab_a));
	}

}
