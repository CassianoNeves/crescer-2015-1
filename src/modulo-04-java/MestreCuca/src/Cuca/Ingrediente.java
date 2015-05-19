package Cuca;


public class Ingrediente {
	
	private String nome;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	private double preco;
	
	public Ingrediente( String nome, double quantidade, UnidadeMedida unidadeMedida, double preco ) {
		this.preco = preco;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

}
