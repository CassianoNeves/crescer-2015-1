package Cuca;


public class Ingrediente {
	
	private String nome;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	
	public Ingrediente( String nome, double quantidade, UnidadeMedida unidadeMedida ) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}

}
