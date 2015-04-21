
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaNoturnaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaNoturnaTest{
    
    final double DELTA = 0.05;
    
    @Test
    public void estrategiaNoturnaComNenhumElfoNoturno(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaNoturna() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( 39, elfoVerde1.getFlechas() );
        assertEquals( 39, elfoVerde2.getFlechas() );
        assertEquals( 39, elfoVerde3.getFlechas() );
    }
    
    @Test
    public void estrategiaNoturnaCom12AtaquesEUmElfoNoturno(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaNoturna() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.alistar( elfoNoturno1 );
        exercito.atacarOrcs( orcs );
        //assert
        
        
        assertEquals( 39, elfoVerde1.getFlechas() );
        assertEquals( 39, elfoVerde2.getFlechas() );
        assertEquals( 39, elfoVerde3.getFlechas() );
        assertEquals( 39, elfoNoturno1.getFlechas() );
        assertEquals( 85.73, elfoNoturno1.getVida(), DELTA );
        
    }

    @Test
    public void estrategiaNoturnaCom12AtaquesApenas3Atacam(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaNoturna() );
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        Elfo elfoNoturno4 = new ElfoNoturno("Noturno 4");
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoNoturno3 );
        exercito.alistar( elfoNoturno4 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( 39, elfoNoturno1.getFlechas() );
        assertEquals( 42, elfoNoturno2.getFlechas() );
        assertEquals( 39, elfoNoturno3.getFlechas() );
        assertEquals( 39, elfoNoturno4.getFlechas() );
        assertEquals( 85.73, elfoNoturno1.getVida(), DELTA );
        assertEquals( 100.0, elfoNoturno2.getVida(), DELTA );
        assertEquals( 85.73, elfoNoturno3.getVida(), DELTA );
        assertEquals( 85.73, elfoNoturno4.getVida(), DELTA );
    }
}
