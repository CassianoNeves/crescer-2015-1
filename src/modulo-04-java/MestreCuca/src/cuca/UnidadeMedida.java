package cuca;

public enum UnidadeMedida {
	
	GRAMA("Grama"),
	UNIDADE("Unidade"),
	XICARA("Xícada"),
	COLHER_SOPA("Colher de Sopa"),
	COLHER_CHA("Colher de Chá");
	
	String nome;
	
	private UnidadeMedida( String nome ){
		this.nome = nome;
	}

}
