package desafio1;

import java.util.List;
import java.util.ArrayList;

public class IndiceMaiusculas {

	public static void main(String[] args) {
		
		List<Integer> indexes = indiceMaiuscula("CWI SoFtware");

	}

	public static List<Integer> indiceMaiuscula(String frase) {
		
		List<Integer> indexes = new ArrayList<Integer>();
		
		String maiuscula = frase.toUpperCase();
		
		for( int i = 0; i < frase.length(); i++ ){
			if( maiuscula.charAt(i) == frase.charAt(i) ){
				if( maiuscula.charAt(i) != ' ' ){
					indexes.add( i );
//					System.out.println( i );
				}
			}
		}
		
		return indexes;
	}
}
