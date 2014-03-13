import java.util.ArrayList;
import java.util.List;

public class DecryptTextMain {

	static byte[] szukanaWiadomosc;
	static ArrayList<String[]> widomosciDoSparsowania;
	static List<byte[]> xorKryptgramow;
	static byte[][] macierzLiter;
	static byte[] odkodowanaWiadomosc;

	public static void main(String[] args) {

		widomosciDoSparsowania = new ArrayList<String[]>();
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
		szukanaWiadomosc = DecryptText.wiadomoscWBajtach(wiadDoOdszyfrowania);
		macierzLiter = new byte[16][szukanaWiadomosc.length];
		System.out.println("Dlugosc wiadomosci: " + szukanaWiadomosc.length);

		// System.out.println("Xor kryptogramow:    ");
		xorKryptgramow = new ArrayList<byte[]>();
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			xorKryptgramow.add(DecryptText.wykonajXor(szukanaWiadomosc,
					wiadomosciSparsowane.get(i)));
		}

		char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'w', 'y',
				'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z',
				'.', ' ', '-', '!', ',', '(', ')' };

		byte[] znak_tab = new byte[szukanaWiadomosc.length];
		List<byte[]> xorZznakiem = new ArrayList<byte[]>();
		List<byte[]> uzupelnienieZerami = new ArrayList<byte[]>();
		odkodowanaWiadomosc = new byte[szukanaWiadomosc.length];
		for (int i = 0; i < alfabet.length; i++) {
			char znak = alfabet[i];
			znajdzZnajWSzukanejWiadomosci(znak, znak_tab, xorZznakiem,
					uzupelnienieZerami);// TODO
		}

		System.out.println(" ");
		// DecryptText.wydrukowanieTablicyDwuwymiarowejLiczb(tablica,
		// szukanaWiadomosc.length);

		// System.out.println(new String(wynik).charAt(157));
		System.out.println(new String(odkodowanaWiadomosc));
	}

	private static void znajdzZnajWSzukanejWiadomosci(char znak,
			byte[] znak_tab, List<byte[]> xorZznakiem,
			List<byte[]> uzupelnienieZerami) {
		/* tablica znaku */
		for (int i = 0; i < szukanaWiadomosc.length; i++) {
			znak_tab[i] = (byte) znak;
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
			uzupelnienieZerami.add(DecryptText
					.uzupelnijZeramiNieprawidloweBity(xorZznakiem.get(i),
							szukanaWiadomosc.length));
		}
		/* tworze macierz */
		for (int i = 0; i < widomosciDoSparsowania.size(); i++) {
			for (int j = 0; j < szukanaWiadomosc.length; j++) {
				macierzLiter[i][j] = (byte) new String(
						uzupelnienieZerami.get(i)).charAt(j);
			}
		}
		/* uzupelniam wynik literka */
		odkodowanaWiadomosc = DecryptText.odszyfrowywanie(macierzLiter,
				szukanaWiadomosc.length, znak, szukanaWiadomosc);

	}
}
