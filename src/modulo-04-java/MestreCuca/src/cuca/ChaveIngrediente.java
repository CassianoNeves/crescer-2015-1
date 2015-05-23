package cuca;

public class ChaveIngrediente {

	private String nome;
	private UnidadeMedida unidadeMedida;
	
	public ChaveIngrediente( Ingrediente ingrediente ) {
		this.nome = ingrediente.getNome();
		this.unidadeMedida = ingrediente.getUnidadeMedida();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveIngrediente other = (ChaveIngrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		return true;
	}
}
