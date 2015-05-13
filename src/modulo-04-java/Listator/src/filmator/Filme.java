package filmator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Filme {

	private ArrayList<Ator> elenco = new ArrayList<>();
	private Genero genero;
	
	
	public Genero getGenero() {
		return genero;
	}

	public Filme( Genero genero ){
		this.genero = genero;
	}
	
	public ArrayList<Ator> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<Ator> elenco) {
		this.elenco = elenco;
	}
	
	public String toString(){
		
		StringBuilder atores = new StringBuilder();
		
		for( Ator ator : elenco ){
			atores.append( ator.getNome() + "\n");
		}
		
		return atores.toString();
	}
	
	public void addAtor( Ator ator ){
		elenco.add( ator );
	}
	
	public ArrayList<Ator> buscarAtores( String nome ){
		ArrayList<Ator> resultado = new ArrayList<Ator>();
		nome = nome.toLowerCase();
		
		for( Ator ator : elenco ){
			if( ator.getNome().toLowerCase().contains( nome ) ){
				resultado.add(ator);
			}
		}
		
		return resultado;
	}	
}
