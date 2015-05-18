package Cuca;
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

	
}
