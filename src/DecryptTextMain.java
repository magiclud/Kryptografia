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

		String[] wiadDoOdszyfrowania = Wiadomosci.wiadDoOdszyfrowania
				.split(" ");
		byte[] szukanaWiadomosc = DecryptText
				.wiadomoscWBajtach(wiadDoOdszyfrowania);

		String[] wiad1 = Wiadomosci.wiad1.split(" ");
		byte[] wiadomosc1 = DecryptText.wiadomoscWBajtach(wiad1);
		String[] wiad2 = Wiadomosci.wiad2.split(" ");
		byte[] wiadomosc2 = DecryptText.wiadomoscWBajtach(wiad2);
		String[] wiad3 = Wiadomosci.wiad3.split(" ");
		byte[] wiadomosc3 = DecryptText.wiadomoscWBajtach(wiad3);
		String[] wiad4 = Wiadomosci.wiad4.split(" ");
		byte[] wiadomosc4 = DecryptText.wiadomoscWBajtach(wiad4);
		String[] wiad5 = Wiadomosci.wiad5.split(" ");
		byte[] wiadomosc5 = DecryptText.wiadomoscWBajtach(wiad5);
		String[] wiad6 = Wiadomosci.wiad6.split(" ");
		byte[] wiadomosc6 = DecryptText.wiadomoscWBajtach(wiad6);
		String[] wiad7 = Wiadomosci.wiad7.split(" ");
		byte[] wiadomosc7 = DecryptText.wiadomoscWBajtach(wiad7);
		String[] wiad8 = Wiadomosci.wiad8.split(" ");
		byte[] wiadomosc8 = DecryptText.wiadomoscWBajtach(wiad8);
		String[] wiad9 = Wiadomosci.wiad9.split(" ");
		byte[] wiadomosc9 = DecryptText.wiadomoscWBajtach(wiad9);
		String[] wiad10 = Wiadomosci.wiad10.split(" ");
		byte[] wiadomosc10 = DecryptText.wiadomoscWBajtach(wiad10);
		String[] wiad11 = Wiadomosci.wiad11.split(" ");
		byte[] wiadomosc11 = DecryptText.wiadomoscWBajtach(wiad11);
		String[] wiad12 = Wiadomosci.wiad12.split(" ");
		byte[] wiadomosc12 = DecryptText.wiadomoscWBajtach(wiad12);
		String[] wiad13 = Wiadomosci.wiad13.split(" ");
		byte[] wiadomosc13 = DecryptText.wiadomoscWBajtach(wiad13);
		String[] wiad14 = Wiadomosci.wiad14.split(" ");
		byte[] wiadomosc14 = DecryptText.wiadomoscWBajtach(wiad14);
		String[] wiad15 = Wiadomosci.wiad15.split(" ");
		byte[] wiadomosc15 = DecryptText.wiadomoscWBajtach(wiad15);
		String[] wiad16 = Wiadomosci.wiad16.split(" ");
		byte[] wiadomosc16 = DecryptText.wiadomoscWBajtach(wiad16);

		/* tablice najczesciej wystepujacych liter */
		byte[] a_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			a_tab[i] = 'a';
		}
		System.out.println("Dlugosc wiadomosci: " + szukanaWiadomosc.length);

		// System.out.println("Xor kryptogramow:    ");
		byte[] xorZWiad1 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc1); // z
																					// pierwsza
																					// wiadomoscia
		byte[] xorZWiad2 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc2); // z
																					// druga
																					// wiadomoscia
		byte[] xorZWiad3 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc3); // z
																					// trzecia
																					// wiadomoscia
		byte[] xorZWiad4 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc4); // z
																					// czwarta
																					// wiadomoscia
		byte[] xorZWiad5 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc5); // z
																					// piata
																					// wiadomoscia
		byte[] xorZWiad6 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc6); // z
																					// piata
																					// wiadomoscia
		byte[] xorZWiad7 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc7); // z
																					// piata
																					// wiadomoscia
		byte[] xorZWiad8 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc8); // z
																					// piata
																					// wiadomoscia
		byte[] xorZWiad9 = DecryptText.wykonajXor(szukanaWiadomosc, wiadomosc9); // z
																					// piata
																					// wiadomoscia
		byte[] xorZWiad10 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc10); // z piata wiadomoscia
		byte[] xorZWiad11 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc11); // z piata wiadomoscia
		byte[] xorZWiad12 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc12); // z piata wiadomoscia
		byte[] xorZWiad13 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc13); // z piata wiadomoscia
		byte[] xorZWiad14 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc14); // z piata wiadomoscia
		byte[] xorZWiad15 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc15); // z piata wiadomoscia
		byte[] xorZWiad16 = DecryptText.wykonajXor(szukanaWiadomosc,
				wiadomosc16); // z piata wiadomoscia

		
		byte[] xorXorITab_a = DecryptText.wykonajXor(xorZWiad1, a_tab);// xor
																		// (xor
																		// z 1 i
																		// tablica
																		// a
		byte[] xorXor2Tab_a = DecryptText.wykonajXor(xorZWiad2, a_tab);// xor
																		// (xor
																		// z 2 i
																		// tablica
																		// a
		byte[] xorXor3Tab_a = DecryptText.wykonajXor(xorZWiad3, a_tab);// xor
																		// (xor
																		// z 3 i
																		// tablica
																		// a
		byte[] xorXor4Tab_a = DecryptText.wykonajXor(xorZWiad4, a_tab);// xor
																		// (xor
																		// z 4 i
																		// tablica
																		// a
		byte[] xorXor5Tab_a = DecryptText.wykonajXor(xorZWiad5, a_tab);// xor
																		// (xor
																		// z 5 i
																		// tablica
																		// a
		byte[] xorXor6Tab_a = DecryptText.wykonajXor(xorZWiad6, a_tab);// xor
																		// (xor
																		// z 5 i
																		// tablica
																		// a
		byte[] xorXor7Tab_a = DecryptText.wykonajXor(xorZWiad7, a_tab);// xor
																		// (xor
																		// z 5 i
																		// tablica
																		// a
		byte[] xorXor8Tab_a = DecryptText.wykonajXor(xorZWiad8, a_tab);// xor
																		// (xor
																		// z 5 i
																		// tablica
																		// a
		byte[] xorXor9Tab_a = DecryptText.wykonajXor(xorZWiad9, a_tab);// xor
																		// (xor
																		// z 5 i
																		// tablica
																		// a
		byte[] xorXor10Tab_a = DecryptText.wykonajXor(xorZWiad10, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor11Tab_a = DecryptText.wykonajXor(xorZWiad11, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor12Tab_a = DecryptText.wykonajXor(xorZWiad12, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor13Tab_a = DecryptText.wykonajXor(xorZWiad13, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor14Tab_a = DecryptText.wykonajXor(xorZWiad14, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor15Tab_a = DecryptText.wykonajXor(xorZWiad15, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a
		byte[] xorXor16Tab_a = DecryptText.wykonajXor(xorZWiad16, a_tab);// xor
																			// (xor
																			// z
																			// 5
																			// i
																			// tablica
																			// a

		// int[] tab = new int[xorXorITab_a.length];
		// for (int i = 0; i < xorXorITab_a.length; i++) {
		// tab[i] = xorXorITab_a[i];
		// System.out.print(tab[i]+" ");
		// }
		// System.out.println(" ");
		/*-------------"Wartosc xora (xorMessageZWiad1 i tablicyLiter_a):    "-----------------------*/
		// uzupeniam 0 inne znaki niz wymagane
		System.out.println(" ");
		System.out.println(" ");
		byte[] xor0 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXorITab_a, szukanaWiadomosc.length);
		byte[] xor1 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor2Tab_a, szukanaWiadomosc.length);
		byte[] xor2 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor3Tab_a, szukanaWiadomosc.length);
		byte[] xor3 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor4Tab_a, szukanaWiadomosc.length);
		byte[] xor4 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor5Tab_a, szukanaWiadomosc.length);
		byte[] xor5 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor6Tab_a, szukanaWiadomosc.length);
		byte[] xor6 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor7Tab_a, szukanaWiadomosc.length);
		byte[] xor7 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor8Tab_a, szukanaWiadomosc.length);
		byte[] xor8 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor9Tab_a, szukanaWiadomosc.length);
		byte[] xor9 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor10Tab_a, szukanaWiadomosc.length);
		byte[] xor10 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor11Tab_a, szukanaWiadomosc.length);
		byte[] xor11 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor12Tab_a, szukanaWiadomosc.length);
		byte[] xor12 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor13Tab_a, szukanaWiadomosc.length);
		byte[] xor13 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor14Tab_a, szukanaWiadomosc.length);
		byte[] xor14 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor15Tab_a, szukanaWiadomosc.length);
		byte[] xor15 = DecryptText.uzupelnijZeramiNieprawidloweBity(
				xorXor16Tab_a, szukanaWiadomosc.length);

		System.out.println("0 : " + new String(xor0));
		System.out.println("1 : " + new String(xor1));
		System.out.println("2 : " + new String(xor2));
		System.out.println("3 : " + new String(xor3));
		System.out.println("4 : " + new String(xor4));
		System.out.println("5 : " + new String(xor5));
		System.out.println("6 : " + new String(xor6));
		System.out.println("7 : " + new String(xor7));
		System.out.println("8 : " + new String(xor8));
		System.out.println("9 : " + new String(xor9));
		System.out.println("10: " + new String(xor10));
		System.out.println("11: " + new String(xor11));
		System.out.println("12: " + new String(xor12));
		System.out.println("13: " + new String(xor13));
		System.out.println("14: " + new String(xor14));
		System.out.println("15: " + new String(xor15));

		byte[][] tablica = new byte[16][szukanaWiadomosc.length];
		for (int j = 0; j < szukanaWiadomosc.length; j++) {
			tablica[0][j] = xor0[j];
			tablica[1][j] = xor1[j];
			tablica[2][j] = xor2[j];
			tablica[3][j] = xor3[j];
			tablica[4][j] = xor4[j];
			tablica[5][j] = xor5[j];
			tablica[6][j] = xor6[j];
			tablica[7][j] = xor7[j];
			tablica[8][j] = xor8[j];
			tablica[9][j] = xor9[j];
			tablica[10][j] = xor10[j];
			tablica[11][j] = xor11[j];
			tablica[12][j] = xor12[j];
			tablica[13][j] = xor13[j];
			tablica[14][j] = xor14[j];
			tablica[15][j] = xor15[j];
		}
		System.out.println();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++)
				System.out.print(tablica[i][j] + " ");
			System.out.println();
		}
		char[] odszyfrowanaWiadomosc = new char[szukanaWiadomosc.length];
		DecryptText.sprawdzenie(tablica, szukanaWiadomosc.length,
				odszyfrowanaWiadomosc, 'a');

	}

}
