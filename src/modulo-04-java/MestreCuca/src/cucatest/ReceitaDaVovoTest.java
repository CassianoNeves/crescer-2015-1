package cucatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import cuca.ChaveIngrediente;
import cuca.Ingrediente;
import cuca.Instrucao;
import cuca.Receita;
import cuca.ReceitasDaVovo;
import cuca.UnidadeMedida;

public class ReceitaDaVovoTest {
	@Test
	public void inserindoReceitaNoLivroDaVovo() throws Exception {
		//arrange
		
		Ingrediente ingrediente1 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 10 );
		Ingrediente ingrediente2 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 5 );
		Ingrediente ingrediente3 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 );
		
		Instrucao instrucao1 = new Instrucao( "passo1" );
		Instrucao instrucao2 = new Instrucao( "passo2" );
		Instrucao instrucao3 = new Instrucao( "passo3" );

		Receita receita1 = new Receita( "Bolo de Fuba");
		
		receita1.addIngrediente( ingrediente1 );
		receita1.addIngrediente( ingrediente2 );
		receita1.addIngrediente( ingrediente3 );
		
		receita1.addInstrucao(instrucao1 );
		receita1.addInstrucao(instrucao2 );
		receita1.addInstrucao(instrucao3 );
		
		List<Receita> esperado = new ArrayList<Receita>();
		esperado.add( receita1 );

		//act
		
		ReceitasDaVovo livroVovo = new ReceitasDaVovo();
		livroVovo.inserir( receita1 );
		List<Receita> obtido = livroVovo.getTodasReceitas();

		//assert
		
		Assert.assertEquals(esperado, obtido);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeInserirReceitaNula() throws Exception {
		//arrange

		Receita receita1 = null;
		//act
		
		ReceitasDaVovo livroVovo = new ReceitasDaVovo();
		livroVovo.inserir( receita1 );
		
		//assert
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeInserirReceitaSemNome() throws Exception {
		//arrange

		Receita receita1 = new Receita( "" );
		//act
		
		ReceitasDaVovo livroVovo = new ReceitasDaVovo();
		livroVovo.inserir( receita1 );
		
		//assert
	}
	
	@Test
	public void bucaReceitaPeloNome() throws Exception {
		//arrange

		Receita esperado = new Receita( "Bolo de Fuba" );
		
		ReceitasDaVovo livroVovo = new ReceitasDaVovo();
		livroVovo.inserir( esperado );
		
		//act
		
		Receita obtido = livroVovo.buscaReceitaPeloNome( "bolo de fuba" );
		
		//assert
		
		Assert.assertEquals( esperado, obtido );
	}
	
	@Test
	public void atualizandoReceitaDoLivro() throws Exception {
		//arrange

		Receita receita = new Receita( "Bolo de Fuba" );
		
		ReceitasDaVovo livroVovo = new ReceitasDaVovo();
		livroVovo.inserir( receita );
		
		Receita esperado = new Receita( "Bolo de Chocolate" );
		
		//act
		
		livroVovo.atualizar( "Bolo de Fuba", esperado );
		Receita obtido = livroVovo.buscaReceitaPeloNome( "bolo de Chocolate" );
		
		//assert
		
		Assert.assertEquals( esperado, obtido );
	}
	
	@Test
	public void calculandoValorTotalDaReceitasDaVovo() throws Exception {
		//arrange
		final double DELTA = 0.05;
		
		Ingrediente ingrediente1 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 10.30 );
		Ingrediente ingrediente2 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 5.75 );
		Ingrediente ingrediente3 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 );
		
		Receita receita1 = new Receita( "Bolo de Fuba" );

		receita1.addIngrediente( ingrediente1 );
		receita1.addIngrediente( ingrediente2 );
		receita1.addIngrediente( ingrediente3 );
		
		Ingrediente ingrediente4 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 8.34 );
		Ingrediente ingrediente5 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 7.67 );
		Ingrediente ingrediente6 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 );
		
		Receita receita2 = new Receita( "Bolo de Fuba" );

		receita1.addIngrediente( ingrediente4 );
		receita1.addIngrediente( ingrediente5 );
		receita1.addIngrediente( ingrediente6 );
		
		Ingrediente ingrediente7 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 8.10 );
		Ingrediente ingrediente8 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 1.10 );
		Ingrediente ingrediente9 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 5.5 );
		
		Receita receita3 = new Receita( "Bolo de Fuba" );

		receita1.addIngrediente( ingrediente7 );
		receita1.addIngrediente( ingrediente8 );
		receita1.addIngrediente( ingrediente9 );
		
		ReceitasDaVovo livro = new ReceitasDaVovo();
		
		livro.inserir( receita1 );
		livro.inserir( receita2 );
		livro.inserir( receita3 );
		
		double esperado = 53.76;
		//act
		
		double obtido = livro.valorTotalDasReceitasDaVovo();
		
		//assert
		
		Assert.assertEquals( esperado, obtido, DELTA );

	}
	
	@Test
	public void buscarReceitasQueNaoPossuemOsIngrediente() throws Exception {
		//arrange
		
		Receita receita1 = new Receita( "Bolo de Fuba" );

		receita1.addIngrediente( new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 10.30 ) );
		receita1.addIngrediente( new Ingrediente( "Leite", 1, UnidadeMedida.COLHER_SOPA, 5.75 ) );
		receita1.addIngrediente( new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 ) );
		
		Receita receita2 = new Receita( "Lazanha" );

		receita2.addIngrediente( new Ingrediente( "Farofa", 3, UnidadeMedida.XICARA, 8.34 ) );
		receita2.addIngrediente( new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 7.67 ) );
		receita2.addIngrediente( new Ingrediente( "Arroz", 1, UnidadeMedida.COLHER_CHA, 3.5 ) );
		
		Receita receita3 = new Receita( "Pizza" );

		receita3.addIngrediente( new Ingrediente( "Farinha de trigo", 3, UnidadeMedida.XICARA, 8.10 ) );
		receita3.addIngrediente( new Ingrediente( "ovo", 1, UnidadeMedida.COLHER_SOPA, 1.10 ) );
		receita3.addIngrediente( new Ingrediente( "carne", 1, UnidadeMedida.COLHER_CHA, 5.5 ) );
		
		ReceitasDaVovo livro = new ReceitasDaVovo();
		
		livro.inserir( receita1 );
		livro.inserir( receita2 );
		livro.inserir( receita3 );
		
		List<Ingrediente> naoPodeTer = new ArrayList<Ingrediente>();
		naoPodeTer.add( new Ingrediente( "Farofa", 3, UnidadeMedida.XICARA, 8.34 ) );
		
		List<Receita> esperado = new ArrayList<Receita>();
		esperado.add( receita1 );
		esperado.add( receita3 );
		
		//act
		
		List<Receita> obtido = livro.buscaReceitasQueNaoPossuem( naoPodeTer );
		
		//assert
		
		Assert.assertEquals( esperado, obtido );
	}
	
	@Test
	public void gerarListaDeCompras() throws Exception {
		//arrange
		
		Receita receita1 = new Receita( "Bolo de Fuba" );

		receita1.addIngrediente( new Ingrediente( "Farinha", 1, UnidadeMedida.XICARA, 10.30 ) );
		receita1.addIngrediente( new Ingrediente( "Leite", 1, UnidadeMedida.COLHER_SOPA, 5.75 ) );
		receita1.addIngrediente( new Ingrediente( "Fermento", 2, UnidadeMedida.COLHER_CHA, 3.5 ) );
		
		Receita receita2 = new Receita( "Lazanha" );

		receita2.addIngrediente( new Ingrediente( "Oleo", 3, UnidadeMedida.XICARA, 8.34 ) );
		receita2.addIngrediente( new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 ) );
		receita2.addIngrediente( new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 10.30 ) );
		
		ReceitasDaVovo livro = new ReceitasDaVovo();
		
		livro.inserir( receita1 );
		livro.inserir( receita2 );
		
		Map<ChaveIngrediente, Integer> esperado = new HashMap<ChaveIngrediente, Integer>();
		esperado.put( new ChaveIngrediente( new Ingrediente( "Farinha", 1, UnidadeMedida.XICARA, 10.30 ) ), 4 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "Fermento", 2, UnidadeMedida.COLHER_CHA, 3.5 ) ), 3 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "Oleo", 3, UnidadeMedida.XICARA, 8.34 ) ), 3 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "Leite", 1, UnidadeMedida.COLHER_SOPA, 5.75 ) ), 1 );
		
		//act

		Map<ChaveIngrediente, Integer> obtido = livro.fazerListaDeCompras( livro.getTodasReceitas() );
		
		//assert
		
		Assert.assertEquals( esperado, obtido );

	}
	
	@Test
	public void gerarListaDeComprasDoMarlon() throws Exception {
		//arrange
		
		Receita receita1 = new Receita( "Arroz de forno" );

		receita1.addIngrediente( new Ingrediente( "arroz", 3, UnidadeMedida.XICARA, 10.30 ) );
		receita1.addIngrediente( new Ingrediente( "sal", 1, UnidadeMedida.COLHER_SOPA, 5.75 ) );
		
		Receita receita2 = new Receita( "Arroz doce" );

		receita2.addIngrediente( new Ingrediente( "arroz", 1, UnidadeMedida.XICARA, 8.34 ) );
		receita2.addIngrediente( new Ingrediente( "leite condensado", 1, UnidadeMedida.UNIDADE, 3.5 ) );
		
		Receita receita3 = new Receita( "Carne de panela" );

		receita3.addIngrediente( new Ingrediente( "carne", 1000, UnidadeMedida.GRAMA, 8.34 ) );
		receita3.addIngrediente( new Ingrediente( "sal", 1, UnidadeMedida.COLHER_SOPA, 3.5 ) );
		
		ReceitasDaVovo livro = new ReceitasDaVovo();
		
		livro.inserir( receita1 );
		livro.inserir( receita2 );
		livro.inserir( receita3 );
		
		Map<ChaveIngrediente, Integer> esperado = new HashMap<ChaveIngrediente, Integer>();
		esperado.put( new ChaveIngrediente( new Ingrediente( "arroz", 1, UnidadeMedida.XICARA, 10.30 ) ), 4 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "sal", 2, UnidadeMedida.COLHER_SOPA, 3.5 ) ), 2 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "leite condensado", 3, UnidadeMedida.UNIDADE, 8.34 ) ), 1 );
		esperado.put( new ChaveIngrediente( new Ingrediente( "carne", 1, UnidadeMedida.GRAMA, 5.75 ) ), 1000 );
		
		//act

		Map<ChaveIngrediente, Integer> obtido = livro.fazerListaDeCompras( livro.getTodasReceitas() );
		
		//assert
		
		Assert.assertEquals( esperado, obtido );

	}
	
}
