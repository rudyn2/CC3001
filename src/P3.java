
public class P3 {
	
	public static boolean esRotacionCircular(String r, String w) {
		
		String s = r+r;
		int ans = s.indexOf(w);
		if (ans == -1)
			return false;
		return true;
		
				
	}
	
	public static boolean esPalindrome(String palabra) {
		
		int largo = palabra.length();
		palabra = palabra.toLowerCase();
		String word1 = "";
		String word2 = "";
		
		for(int i = 0; i <= largo-1; i++) {
			String letra = Character.toString(palabra.charAt(i));
			if (letra.equals(" ")) continue;
			word2 = word2 + letra;
		}

		
		for(int i=largo-1; i>=0; i--) {
			String letra = Character.toString(palabra.charAt(i));
			if (letra.equals(" ")) continue;
			word1 = word1 + letra;
		}
		
		return word1.equals(word2);
	}
	
	public static String quitarLetra(String s, char c) {
		String sf = "";
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(i) == c) 
				continue;
			sf = sf + s.charAt(i);
		}
		return sf;
	}
	public static boolean esCompleto(String palabra) {
		
		int largo = palabra.length();
		palabra = palabra.toLowerCase();
		String alfa = "qwertyuiopasdfghjklzxcvbnm";
		
		for(int i=0; i<=largo-1; i++) {

			char letra = palabra.charAt(i);
			if (letra == ' ') continue;
			alfa = quitarLetra(alfa, letra);
		}
		if (alfa.length() == 0) return true;
		return false;
	}
	
	
	
	public static void main(String[] args) {
	}

}
