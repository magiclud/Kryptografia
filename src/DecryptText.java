
public class DecryptText {



	public static byte[] wykonajXor(byte[] wiad1, byte[] wiad2) {

		String xorowananaWiadomosc= "";
		byte wynik[] = new byte[wiad1.length];
		int min = Math.min(wiad1.length, wiad2.length);
		for (int i = 0; i < min; i++) {
			wynik[i] = (byte) (wiad1[i] ^ wiad2[i]);
		}
//		for (int i = 0; i < min; i++) {
//			xorowananaWiadomosc = xorowananaWiadomosc + wynik[i] + " ";
//		}
		return  wynik;
	}

	static String tablicaHex[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
	public static String zapisHex(byte[] wynik) {

		int podstawa = 16;
		String liczbaHex = "";
	
		for (int i=0; i<wynik.length; i++){
		int dana = wynik[i];
		if(dana ==0){
			liczbaHex = tablicaHex[0] + liczbaHex;
		}
		while (dana > 0) {
			liczbaHex = tablicaHex[(int)dana % podstawa] + liczbaHex;
			dana = dana / podstawa;
		}
		}
		return liczbaHex;
	}
	public static void wyswietlenie(byte[] xor) {
		for(int i =0; i< xor.length; i++){
			System.out.print(xor[i] + " ");
		}
		System.out.println("");
	}
	public static byte[] przeunicieElementowTablicy(byte[] mozliweWyrazenie, int maksymalnaDlugosc, int oIle) {
		if(maksymalnaDlugosc<mozliweWyrazenie.length + oIle ){
			//throw wyjatek
		}
		byte[] pom = new byte[maksymalnaDlugosc];
		int oileTemp = oIle;
		for(int i =mozliweWyrazenie.length-1;i>=0; i--, oileTemp-- ){
			pom[mozliweWyrazenie.length-1+oileTemp]= mozliweWyrazenie[i];
		 }
		for(int i=oIle; oIle>0; oIle--){
			pom[i-1]=0;
		}
		return pom;
	}

}
