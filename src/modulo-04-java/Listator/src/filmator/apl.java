package filmator;

public class apl {
	
	public static void main(String[] args) {
		
		Filme filme1 = new Filme(Genero.ACAO);
		Filme filme2 = new Filme(Genero.ACAO);
		Filme filme3 = new Filme(Genero.ACAO);
		Filme filme4 = new Filme(Genero.COMEDIA);
		Filme filme5 = new Filme(Genero.COMEDIA);
		
		Netflox filmes = new Netflox();
		
		filmes.addFilme(filme1);
		filmes.addFilme(filme2);
		filmes.addFilme(filme3);
		filmes.addFilme(filme4);
		
		filmes.reproduzirFilme( filme1 );
		filmes.reproduzirFilme( filme2 );
		filmes.reproduzirFilme( filme3 );
		filmes.reproduzirFilme( filme4 );

		System.out.println(filmes.getContadorDeVisualizacao().get(Genero.ACAO));
		System.out.println(filmes.getContadorDeVisualizacao().get(Genero.COMEDIA));
	}

}
