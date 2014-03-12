import java.nio.charset.Charset;

public class DecryptText {

	public static byte[] wykonajXor(byte[] wiad1, byte[] wiad2) {

		byte wynik[] = new byte[wiad1.length];
		int min = Math.min(wiad1.length, wiad2.length);
		for (int i = 0; i < min; i++) {
			wynik[i] = (byte) (wiad1[i] ^ wiad2[i]);
		}
		return wynik;
	}

	public static byte[] wiadomoscWBajtach(String[] wiadomosc) {
		byte[] doDeszyfracji = new byte[wiadomosc.length];
		for (int i = 0; i < wiadomosc.length; i++) {
			char ja = (char) Integer.parseInt(wiadomosc[i], 2);
			doDeszyfracji[i] = (byte) ja;
		}
		return doDeszyfracji;
	}

	public static void wyswietlenie(byte[] xor) {
		for (int i = 0; i < xor.length; i++) {
			System.out.print(xor[i] + " ");
		}
		System.out.println("");
	}

	static String alfabet = "^[a-zA-UWY-Z\\,\\.\\-\\!\\(\\)\\s]+$";

	public static byte[] uzupelnijZeramiNieprawidloweBity(byte[] mozliweLitery, int length) {
	
		char[] litery = new char[length];
		int[] tab = new int[length];
		for(int i =0; i<length; i++){
			litery[i] = (char)mozliweLitery[i];
			String znak = Character.toString(litery[i]);
			if(!znak.matches(alfabet)){
				litery[i]=0;
			}
			tab[i]=litery[i];
		}
		byte[] odpowiednieLitery = new byte[length];
		for (int i = 0; i < length; i++) {
			odpowiednieLitery[i]=0;
			odpowiednieLitery[i]=(byte) tab[i];
		}
		return odpowiednieLitery;
			
	}

	public static void sprawdzenie(byte[][] tablica, int length, char[] odszyfrowanaWiadomosc, char c) {
		
		for (int j = 0; j < length; j++) {
			for(int i=0; i<16; i++){
				if(!(tablica[0][j]==0||tablica[1][j]==0||tablica[2][j]==0||tablica[3][j]==0||tablica[4][j]==0||tablica[5][j]==0||tablica[6][j]==0||tablica[7][j]==0||tablica[8][j]==0||tablica[9][j]==0||tablica[10][j]==0||tablica[11][j]==0||tablica[12][j]==0||tablica[13][j]==0||tablica[14][j]==0||tablica[15][j]==0)){
					//System.out.println("Tu jest literka: " + j);
					odszyfrowanaWiadomosc[j]=c;
				}
			}
		}
	}
	}


