package Filmator;

import javax.swing.JOptionPane;

import junit.framework.Assert;

import org.junit.Test;

import filmator.Filme;
import filmator.Genero;
import filmator.Netflox;


public class NetfloxTest {
	

	@Test(expected=IllegalArgumentException.class)
	public void c() throws Exception {
		//arrange
		Filme filme1 = new Filme(Genero.ACAO);
		Netflox filmes = new Netflox();
		//act
		filmes.reproduzirFilme(filme1);
	}
	
	@Test
	public void contandoQuantidadeDeVezesDeGenerosAssistidos() throws Exception {
		//arrange
		Filme filme1 = new Filme(Genero.ACAO);
		Filme filme2 = new Filme(Genero.ACAO);
		Filme filme3 = new Filme(Genero.ACAO);
		Filme filme4 = new Filme(Genero.COMEDIA);

		
		Netflox filmes = new Netflox();
		
		filmes.addFilme(filme1);
		filmes.addFilme(filme2);
		filmes.addFilme(filme3);
		filmes.addFilme(filme4);
		
		int esperadoAcao = 3;
		int esperadoComedia= 1;
		
		//act
		filmes.reproduzirFilme( filme1 );
		filmes.reproduzirFilme( filme2 );
		filmes.reproduzirFilme( filme3 );
		filmes.reproduzirFilme( filme4 );
		
		int obtidoAcao = filmes.getContadorDeVisualizacao().get(Genero.ACAO);
		int obtidoComedia = filmes.getContadorDeVisualizacao().get(Genero.COMEDIA);
		//assert
		Assert.assertEquals(esperadoAcao, obtidoAcao);
		Assert.assertEquals(esperadoComedia, obtidoComedia);	
	}
	
	@Test
	public void filmeNaoAssistidonaoPodeContar() throws Exception {
		//arrange
		Filme filme1 = new Filme(Genero.ACAO);
		Filme filme2 = new Filme(Genero.ACAO);
		Filme filme3 = new Filme(Genero.COMEDIA);
		Filme filme4 = new Filme(Genero.COMEDIA);

		Netflox filmes = new Netflox();
		
		filmes.addFilme(filme1);
		filmes.addFilme(filme2);
		filmes.addFilme(filme3);
		filmes.addFilme(filme4);
		
		int esperadoAcao = 1;
		int esperadoComedia= 1;
		
		//act
		filmes.reproduzirFilme( filme1 );
		filmes.reproduzirFilme( filme4 );
		
		int obtidoAcao = filmes.getContadorDeVisualizacao().get(Genero.ACAO);
		int obtidoComedia = filmes.getContadorDeVisualizacao().get(Genero.COMEDIA);
		//assert
		Assert.assertEquals(esperadoAcao, obtidoAcao);
		Assert.assertEquals(esperadoComedia, obtidoComedia);
	}
	
	@Test
	public void gerarRelatorioDeFilmesAssistidosPorGenero() throws Exception {
		//arrange
		Filme filme1 = new Filme(Genero.ACAO);
		Filme filme2 = new Filme(Genero.ACAO);
		Filme filme3 = new Filme(Genero.COMEDIA);
		Filme filme4 = new Filme(Genero.COMEDIA);

		Netflox filmes = new Netflox();
		
		filmes.addFilme(filme1);
		filmes.addFilme(filme2);
		filmes.addFilme(filme3);
		filmes.addFilme(filme4);
		
		String esperado = "Genero: Ação assistido 2 vezes.\nGenero: Comédia assistido 2 vezes.\n";
		//act
		filmes.reproduzirFilme( filme1 );
		filmes.reproduzirFilme( filme2 );
		filmes.reproduzirFilme( filme3 );
		filmes.reproduzirFilme( filme4 );
		
		String obtido = filmes.getRelatorio();
		
		//assert
		Assert.assertEquals(esperado, obtido);
		
		
		//System.out.println(obtido);
	
	}

}
