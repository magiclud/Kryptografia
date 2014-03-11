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

}
