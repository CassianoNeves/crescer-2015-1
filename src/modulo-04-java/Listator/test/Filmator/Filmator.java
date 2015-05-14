package Filmator;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import filmator.Ator;
import filmator.Filme;
import filmator.Genero;

public class Filmator {

	@Test
	public void toStringDaClassAtor() throws Exception {
		//arrange
		Ator ator = new Ator( "Cassiano Neves" );
		
		String esperado = "Nome: Cassiano Neves";
		//act
		
		String obtido = ator.toString();
		
		//assert
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void toStringDaClasseFime() throws Exception {
		//arrange
		Ator ator = new Ator( "Cassiano Neves" );
		Filme filme = new Filme(Genero.ACAO);
		
		String esperado = "Cassiano Neves\n";
		//act
		
		filme.addAtor(ator);
		String obtido = filme.toString();
		
		//assert
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void addAtorAoFilme() throws Exception{
		//arrange
		Ator ator1 = new Ator( "Cassiano Neves" );
		Ator ator2 = new Ator( "Maria Joaquini" );
		Ator ator3 = new Ator( "Fernando Neves" );
		Filme filme = new Filme(Genero.ACAO);
		
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		esperado.add( ator1 );
		esperado.add( ator2 );
		esperado.add( ator3 );
		//act
		
		filme.addAtor(ator1);
		filme.addAtor(ator2);
		filme.addAtor(ator3);
		ArrayList<Ator> obtido = filme.getElenco();
		
		//assert
		
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void buscaAtoresPorParteDoNome(){
		//arrange
		Ator ator1 = new Ator( "Cassiano Neves" );
		Ator ator2 = new Ator( "Maria Joaquini" );
		Ator ator3 = new Ator( "Fernando Neves" );
		
		Filme filme = new Filme(Genero.ACAO);
		filme.addAtor(ator1);
		filme.addAtor(ator2);
		filme.addAtor(ator3);
		
		ArrayList<Ator> esperado = new ArrayList<Ator>( Arrays.asList( ator1, ator3));
		
		//act
		ArrayList<Ator> obtido = filme.buscarAtores( "Neves" );
		
		//assert
		
		Assert.assertEquals(esperado, obtido);
	}
	
	
}
