package Cuca;


public class Ingrediente {
	
	private String nome;
	private int quantidade;
	private UnidadeMedida unidadeMedida;
	

	private double preco;
	
	public Ingrediente( String nome, int quantidade, UnidadeMedida unidadeMedida, double preco ) {
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
	
	public int getQuantidade() {
		return quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

}
