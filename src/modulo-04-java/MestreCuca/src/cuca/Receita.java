package cuca;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private List<Instrucao> instrucoes = new ArrayList<Instrucao>();
	
	public Receita( String nome ) {
		this.nome = nome;
	}
	
	public void addIngrediente( Ingrediente ingrediente ){
		this.ingredientes.add( ingrediente );
	}
	
	public void addInstrucao( Instrucao instrucao ){
		this.instrucoes.add( instrucao );
	}
	
	public String getNome() {
		return nome;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public List<Instrucao> getInstrucao() {
		return instrucoes;
	}
	
	public double valorDaReceita(){
		
		double total = 0;
		
		for (Ingrediente ingrediente : ingredientes) {
			total += ingrediente.getPreco();
		}
		
//		DecimalFormat df = new DecimalFormat("0.##");  
//		String totalString = df.format( total );  
//		
//		total = Double.parseDouble( totalString );
		
//		total = ( (int) ( total * 100) ) / 100;
		
		return total;
	}
	
	public boolean pesquisarIngredienteNaReceita( Ingrediente ingrediente ){
		
		boolean tem = false;
		
		for ( Ingrediente ingredienteAtual : ingredientes ) {
			if( ingredienteAtual.getNome().equalsIgnoreCase( ingrediente.getNome() ) ){
				tem = true;
			}
		}
		
		return tem;
	}
}
