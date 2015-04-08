

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemDoInventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemDoInventarioTest{
    
    @Test
    public void itemTemDescricaoEQuantidade(){
        //arrange
        String descricaoEsperada = "espada";
        int quantidadeEsperada = 2;
        ItemDoInventario item;
        //act
        item = new ItemDoInventario(descricaoEsperada, quantidadeEsperada);
        //assert
        assertEquals(descricaoEsperada, item.getDescricao());
        assertEquals(quantidadeEsperada, item.getQuantidade());
    }
    
    @Test
    public void itemTemDescricaoNulaEQuantidadeNegativa(){
        //arrange
        String descricaoEsperada = null;
        int quantidadeEsperada = -2;
        ItemDoInventario item;
        //act
        item = new ItemDoInventario(descricaoEsperada, quantidadeEsperada);
        //assert
        assertEquals(descricaoEsperada, item.getDescricao());
        assertEquals(quantidadeEsperada, item.getQuantidade());
    }
    
}
