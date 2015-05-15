package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpresaDeFIlmes {

	protected ArrayList<Filme> filmes = new ArrayList<Filme>();
	protected HashMap<Genero, Integer> contadorDeVisualizacao = new HashMap<>();
	
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
	
	public String getRelatorio(){
		StringBuilder relatorio = new StringBuilder();
		
		for(  Map.Entry<Genero,Integer> generoQts : contadorDeVisualizacao.entrySet()){
			relatorio.append("Genero: " + generoQts.getKey().getNome() +
							 " assistido " + generoQts.getValue() + " vezes.\n");
		}
		
		return relatorio.toString();
		
	}
	
	public HashMap<Genero, Integer> getContadorDeVisualizacao() {
		return contadorDeVisualizacao;
	}

	public void addFilme( Filme filme ){
		filmes.add( filme );
	}
}
