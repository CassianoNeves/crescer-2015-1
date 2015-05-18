package apis;

import junit.framework.Assert;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringTest {
	@Test
	public void indexOfTest() throws Exception {
		//arrange
		String s = "cassiano";
		int esperado = 1;
		
		//act
		int obtido = s.indexOf("a");
		
		//assert
		Assert.assertEquals(esperado, obtido);
	}

	@Test
	public void replaceTest() throws Exception {
		//arrange
		String s = "cussiuno";
		String esperado = "cassiano";
		
		//act
		
		String obtido = s.replace('u', 'a');
		
		//assert
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void splitTest() throws Exception {
		//arrange
		String s = "cassio";
		String[] esperado = {"c", "ssio"};
		
		//act
		
		String[] obtido = s.split("a");
//		for (String sa : obtido) {
//			System.out.println(sa);
//		}
		//assert
		assertArrayEquals(esperado, obtido);
	}
}
