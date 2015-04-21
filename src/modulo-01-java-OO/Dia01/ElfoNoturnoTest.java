

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest{
    
    @Test
    public void elfoNoturnoGanhaOTriploDeExperienciaAtirandoFlecha(){
        //arrange
        final double DELTA = 0.05;
        ElfoNoturno elfo = new ElfoNoturno("Noturno");
        Orc orc = new Orc("cassiano");
        //act
        elfo.atirarFlecha( orc );
        //assert
        assertEquals( 3, elfo.getExperiencia() );
        assertEquals( 41, elfo.getFlechas() );
        assertEquals( 95.0, elfo.getVida(), DELTA );
    }
    
    @Test
    public void elfoNoturnoAtirandoVariasFlechas(){
        //arrange
        final double DELTA = 0.05;
        ElfoNoturno elfo = new ElfoNoturno("Noturno");
        Orc orc = new Orc("cassiano");
        //act
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        elfo.atirarFlecha( orc );
        //assert
        assertEquals( 15, elfo.getExperiencia() );
        assertEquals( 37, elfo.getFlechas() );
        assertEquals( 77.37, elfo.getVida(), DELTA );
    }
    
    @Test
    public void elfoNoturnoAtirandoVariasFlechasAteMorrer(){
        //arrange
        final double DELTA = 0.05;
        ElfoNoturno elfo = new ElfoNoturno("Noturno");
        Orc orc = new Orc("cassiano");
        //act

        for( int i = 0; elfo.getVida() > 1; i++ ){
            elfo.atirarFlecha( orc );
        }
        //assert
        assertEquals( 270, elfo.getExperiencia() );
        assertEquals( 0.98, elfo.getVida(), DELTA );
    }
    
    
}
