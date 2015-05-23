package cucatest;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import cuca.Ingrediente;
import cuca.Receita;
import cuca.UnidadeMedida;

public class ReceitaTest {
	
	@Test
	public void saberOValorTotalDeUmaReceita() throws Exception {
		//arrange
		
		final double DELTA = 0.05;
		
		Ingrediente ingrediente1 = new Ingrediente( "Farinha", 3, UnidadeMedida.XICARA, 10.434 );
		Ingrediente ingrediente2 = new Ingrediente( "Oleo", 1, UnidadeMedida.COLHER_SOPA, 5.123 );
		Ingrediente ingrediente3 = new Ingrediente( "Fermento", 1, UnidadeMedida.COLHER_CHA, 3.5 );
		
		Receita receita1 = new Receita( "Bolo de Fuba");
		
		receita1.addIngrediente( ingrediente1 );
		receita1.addIngrediente( ingrediente2 );
		receita1.addIngrediente( ingrediente3 );
		
		double esperado = 19.05;
		//act
		
		double obtido = receita1.valorDaReceita();
		
		//assert
		
		Assert.assertEquals( esperado, obtido, DELTA );
	}
}
