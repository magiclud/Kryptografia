import java.util.ArrayList;
import java.util.List;

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

		ArrayList<String[]> widomosciDoSparsowania = new ArrayList<String[]>();
		widomosciDoSparsowania.add(Wiadomosci.wiad1.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad2.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad3.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad4.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad5.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad6.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad7.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad8.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad9.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad10.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad11.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad12.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad13.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad14.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad15.split(" "));
		widomosciDoSparsowania.add(Wiadomosci.wiad16.split(" "));

		/* wiadomosci sparsowane i zapisane jako bajty */
		List<byte[]> wiadomosciSparsowane = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			wiadomosciSparsowane.add(DecryptText
					.wiadomoscWBajtach(widomosciDoSparsowania.get(i)));
		}

		/* wiadomosc do odszyfrowania */
		String[] wiadDoOdszyfrowania = Wiadomosci.wiadDoOdszyfrowania
				.split(" ");
		byte[] szukanaWiadomosc = DecryptText
				.wiadomoscWBajtach(wiadDoOdszyfrowania);
		byte[][] tablica = new byte[16][szukanaWiadomosc.length];
		System.out.println("Dlugosc wiadomosci: " + szukanaWiadomosc.length);

		// System.out.println("Xor kryptogramow:    ");
		List<byte[]> xorKryptgramow = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorKryptgramow.add(DecryptText.wykonajXor(szukanaWiadomosc,
					wiadomosciSparsowane.get(i)));
		}
		
		char [] alfabet={'a','e', 'i',' ', 'o', '.','z','s', 'k', 'p', 'r' };
		
		byte[] znak_tab = new byte[szukanaWiadomosc.length];
		List<byte[]> xorZznakiem = new ArrayList<byte[]>();
		List<byte[]> uzupelnienieZerami = new ArrayList<byte[]>();
		byte[] wynik= new byte[szukanaWiadomosc.length];
		for(int i =0; i<alfabet.length; i++){
			char znak = alfabet[i];
			znajdzZnajWSzukanejWiadomosci(znak, znak_tab, xorZznakiem);//TODO
		}


		
		/* tablice liter a */
		byte[] a_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			a_tab[i] = 'a';
		}
		/* xor (xor kryptogramow i tablicy a ) */
		List<byte[]> xorZa = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZa.add(DecryptText.wykonajXor(xorKryptgramow.get(i), a_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		List<byte[]> uzupelnienieZerami = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami.add(DecryptText
					.uzupelnijZeramiNieprawidloweBity(xorZa.get(i),
							szukanaWiadomosc.length));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'a', szukanaWiadomosc);

		
		/* tablice kropek */
		byte[] kropka_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			kropka_tab[i] = '.';
		}
		/* xor (xor kryptogramow i tablicy . ) */
		List<byte[]> xorZKropka = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZKropka.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					kropka_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		List<byte[]> uzupelnienieZerami2 = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami2
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZKropka.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami2.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, '.', szukanaWiadomosc);
		
		
		
		/* tablice k */
		byte[] k_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			k_tab[i] = 'k';
		}
		/* xor (xor kryptogramow i tablicy k ) */
		List<byte[]> xorZk = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZk.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					k_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		List<byte[]> uzupelnienieZerami3 = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami3
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZk.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami3.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'k', szukanaWiadomosc);
		
		
		
		/* tablice p */
		byte[] p_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			p_tab[i] = 'p';
		}
		/* xor (xor kryptogramow i tablicy k ) */
		List<byte[]> xorZp = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZp.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					p_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		List<byte[]> uzupelnienieZerami4 = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami4
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZp.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami4.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'p', szukanaWiadomosc);
		
		/* tablice r */
		byte[] r_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			r_tab[i] = 'r';
		}
		/* xor (xor kryptogramow i tablicy k ) */
		List<byte[]> xorZr = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZr.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					r_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		List<byte[]> uzupelnienieZerami5 = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami5
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZr.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami5.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'r', szukanaWiadomosc);
		
		
		/* tablice z */
		byte[] z_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			z_tab[i] = 'z';
		}
		/* xor (xor kryptogramow i tablicy k ) */
		List<byte[]> xorZz = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZz.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					z_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZz.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'z', szukanaWiadomosc);
		
		/* tablice i */
		byte[] i_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			i_tab[i] = 'i';
		}
		/* xor (xor kryptogramow i tablicy i ) */
		List<byte[]> xorZi = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZi.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					i_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZi.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'i', szukanaWiadomosc);
		
		/* tablice e */
		byte[] e_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			e_tab[i] = 'e';
		}
		/* xor (xor kryptogramow i tablicy e ) */
		List<byte[]> xorZe = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZe.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					e_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZe.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'e', szukanaWiadomosc);
		
		
		/* tablice spacja */
		byte[] spacja_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			spacja_tab[i] = ' ';
		}
		/* xor (xor kryptogramow i tablicy spacja ) */
		List<byte[]> xorZspacja = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZspacja.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					spacja_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZspacja.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, ' ', szukanaWiadomosc);
		
		
		
		/* tablice znak */
		byte[] znak_tab = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			znak_tab[i] = 'o';
		}
		/* xor (xor kryptogramow i tablicy znaku ) */
		List<byte[]> xorZznakiem = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZznakiem.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					znak_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZznakiem.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 'o', szukanaWiadomosc);
		
		/* tablice znak s */
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			znak_tab[i] = 's';
		}
		/* xor (xor kryptogramow i tablicy znaku ) */
		xorZznakiem.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorZznakiem.add(DecryptText.wykonajXor(xorKryptgramow.get(i),
					znak_tab));
		}
		// uzupeniam 0 inne znaki niz wymagane
		uzupelnienieZerami.clear();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			uzupelnienieZerami
					.add(DecryptText
							.uzupelnijZeramiNieprawidloweBity(xorZznakiem.get(i),
									szukanaWiadomosc.length));
//			System.out.println(i + ": "
//					+ new String(uzupelnienieZerami2.get(i)));
		}
		/*tworze macierz*/
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				tablica[i][j] = (byte) new String(uzupelnienieZerami.get(i))
						.charAt(j);
			}
		}
		/*uzupelniam wynik literka*/
		wynik=	DecryptText.odszyfrowywanie(tablica, szukanaWiadomosc.length, 's', szukanaWiadomosc);
		
		
		System.out.println(" ");
//		DecryptText.wydrukowanieTablicyDwuwymiarowejLiczb(tablica,
//				szukanaWiadomosc.length);

		
		//System.out.println(new String(wynik).charAt(157));
		System.out.println(new String(wynik));
	}



}
