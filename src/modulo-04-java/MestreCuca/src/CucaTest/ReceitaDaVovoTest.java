package CucaTest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import Cuca.Ingrediente;
import Cuca.Instrucao;
import Cuca.Receita;
import Cuca.ReceitasDaVovo;
import Cuca.UnidadeMedida;

public class ReceitaDaVovoTest {
	@Test
	public void inserindoReceitaNoLivroDaVovo() throws Exception {
		//arrange
		
		Ingrediente ingrediente1 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA );
		Ingrediente ingrediente2 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA );
		Ingrediente ingrediente3 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA );
		
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
}
