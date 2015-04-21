

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest{

    @Test
    public void elfoVerdeGanhaODobroDeExperienciaAoAtirarFlechaEmOrc(){
        //arrange
        final double DELTA = 0.05;
        ElfoVerde elfo = new ElfoVerde("Verde");
        Orc orc = new Orc("cassiano");
        //act
        elfo.atirarFlecha( orc );
        //assert
        assertEquals( 2, elfo.getExperiencia() );
        assertEquals( 41, elfo.getFlechas() );
        assertEquals( 100.0, orc.getVida(), DELTA );
    }
    
    @Test
    public void elfoVerdeAtirandoVariasFlechasEmUmOrc(){
        final double DELTA = 0.05;
        //arrange
        ElfoVerde elfo = new ElfoVerde("Verde");
        Orc orc = new Orc("cassiano");
        //act
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        //assert
        assertEquals( 10, elfo.getExperiencia() );
        assertEquals( 37, elfo.getFlechas() );
        assertEquals( 60.0, orc.getVida(), DELTA );
    }
    
    @Test
    public void elfoVerdeSemItens(){
        //arrange
        ElfoVerde elfo = new ElfoVerde("Verde");
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<>();
        //act
        //assert
        assertEquals( resultadoEsperado, elfo.getItens() );
    }
    
    @Test
    public void elfoVerdeNaoPodeReceberItemForaDoPermitido(){
        //arrange
        ElfoVerde elfo = new ElfoVerde("Verde");
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<>();
        ItemDoInventario item1 = new ItemDoInventario("espada", 3);
        //act
        elfo.addItem( item1 );
        //assert
        assertEquals( resultadoEsperado, elfo.getItens() );
    }
    
    @Test
    public void elfoVerdeRecenboItemPermitido(){
        //arrange
        ElfoVerde elfo = new ElfoVerde("Verde");
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<>();
        ItemDoInventario item1 = new ItemDoInventario("Espada de aço valiriano", 3);
        ItemDoInventario item2 = new ItemDoInventario("Arco e Flecha de vidro", 2);
        resultadoEsperado.add( item1 );
        resultadoEsperado.add( item2 );
        //act
        elfo.addItem( item1 );
        elfo.addItem( item2 );
        //assert
        assertEquals( resultadoEsperado, elfo.getItens() );
    }
    
    
}
