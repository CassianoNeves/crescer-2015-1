package filmator;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Netflox {
	
	
	private ArrayList<Filme> filmes = new ArrayList<Filme>();
	private HashMap<Genero, Integer> contadorDeVisualizacao = new HashMap<>();
	
	public void reproduzirFilme( Filme filme ){
		
		if( filmes.contains( filme ) ){
			System.out.println("O filme está sendo reproduzido!");
			
			if(contadorDeVisualizacao.containsKey(filme.getGenero())){
				Integer contar = contadorDeVisualizacao.get(filme.getGenero());
				contar++;
				contadorDeVisualizacao.put(filme.getGenero(), contar );
			} else{
				contadorDeVisualizacao.put(filme.getGenero(), 1);
			}
		} else{
			throw new IllegalArgumentException("O filme não existe!");
		}
	}
	
	public HashMap<Genero, Integer> getContadorDeVisualizacao() {
		return contadorDeVisualizacao;
	}

	public void addFilme( Filme filme ){
		filmes.add( filme );
	}

}
