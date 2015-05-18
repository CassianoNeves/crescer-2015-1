package desafio1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class IndiceTest {
	@Test
	public void testandoStringDoDesafio() throws Exception {
		//arrange
		String frase = "CWI SoFtware";
		
		List<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0);
		esperado.add(1);
		esperado.add(2);
		esperado.add(4);
		esperado.add(6);
		
		//act
		List<Integer> obtido = 
				IndiceMaiusculas.indiceMaiuscula( frase );

		//assert
		Assert.assertEquals(esperado, obtido);
	}

}
