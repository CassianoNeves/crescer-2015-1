package cuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class ReceitasDaVovo implements LivroReceitas{

	private List<Receita> livro = new ArrayList<>();
	
	public double valorTotalDasReceitasDaVovo(){
		
		double total = 0;
		
		for (Receita receita : livro) {
			total += receita.valorDaReceita();
		}
		
		return total;
	}
	
	public List<Receita> buscaReceitasQueNaoPossuem( List<Ingrediente> ingredientes ){
		
		List<Receita> naoTemOsIngredientes = new ArrayList<Receita>();
		
		for ( Receita receita : livro ) {
			for (Ingrediente ingrediente : ingredientes) {
				if( !receita.pesquisarIngredienteNaReceita( ingrediente ) ){
					naoTemOsIngredientes.add( receita );
				}
			}
		}
		
		return naoTemOsIngredientes;
	}
	
	public Map<ChaveIngrediente, Integer> fazerListaDeCompras( List<Receita> receitas ){
		
		Map<ChaveIngrediente, Integer> listaDeCompras = new HashMap<ChaveIngrediente, Integer>();
		
		for ( Receita receita : receitas ) {
			for ( Ingrediente ingrediente : receita.getIngredientes() ) {
				
				ChaveIngrediente chaveIngrediente = new ChaveIngrediente( ingrediente );
				
				if( listaDeCompras.containsKey( chaveIngrediente ) ){
					int quantidade = listaDeCompras.get( chaveIngrediente );
					quantidade += ingrediente.getQuantidade();
					listaDeCompras.put( chaveIngrediente, quantidade );
				} else{
					listaDeCompras.put( chaveIngrediente, ingrediente.getQuantidade() );
				}
			}
		}
		
		return listaDeCompras;
	}
	
	@Override
	public void inserir(Receita receita) {
		if( receita == null ){
			lançaExecao( "A receita está nula!");
		}
		if( receita.getNome().equals( "" ) ){
			lançaExecao( "A receita não tem nome!");
		} else{
			livro.add( receita );
			System.out.println("Receita inserida com sucesso!");
		}
	}
	
	protected void lançaExecao( String descricao ) {
		throw new IllegalArgumentException( "Erro: " + descricao );
	}

	@Override
	public void atualizar( String nome, Receita receitaAtualizada ) {
		for ( Receita receita : livro ) {
			if( receita.getNome().equalsIgnoreCase( nome ) ){
				livro.set( livro.indexOf(receita), receitaAtualizada );
			}
		}
	}

	@Override
	public void excluir( String nome ) {
		for ( Receita receita : livro ) {
			if(receita.getNome().equalsIgnoreCase( nome )){
				livro.remove( receita );
			}
		}
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return livro;
	}

	@Override
	public Receita buscaReceitaPeloNome( String nome ) {
		
		Receita retorna = null;
		
		for ( Receita receita : livro ) {
			if( receita.getNome().equalsIgnoreCase( nome )){
				retorna = receita;
			}
		}
		
		return retorna;
	}
}
