
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
    
    @Test
    public void elfosAtacandoOrcsComEstrategiaNoturna(){
        //arrange
        
        Elfo elfoVerde1 = new ElfoVerde("Green 1");
        Elfo elfoVerde2 = new ElfoVerde("Green 2");
        Elfo elfoVerde3 = new ElfoVerde("Green 3");
        Elfo elfoVerde4 = new ElfoVerde("Green 4");
        Elfo elfoVerde5 = new ElfoVerde("Green 5");
        Elfo elfoVerde6 = new ElfoVerde("Green 6");
        Elfo elfoVerde7 = new ElfoVerde("Green 7");
        Elfo elfoNoturno1 = new ElfoNoturno("Night 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Night 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Night 3");
        Orc orc1 = new Orc();
        Orc orc2 = new Orc();
        Orc orc3 = new Orc();
        
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try{
            exercito.alistar(elfoVerde1);
            exercito.alistar(elfoVerde2);
            exercito.alistar(elfoVerde3);
            exercito.alistar(elfoVerde4);
            exercito.alistar(elfoVerde5);
            exercito.alistar(elfoVerde6);
            exercito.alistar(elfoVerde7);
            exercito.alistar(elfoNoturno1);
            exercito.alistar(elfoNoturno2);
            exercito.alistar(elfoNoturno3);
        }catch( NaoPodeAlistarException erro ){
            System.out.println( erro );
        }
        ArrayList<Orc> orcs = new ArrayList<>( 
            Arrays.asList( orc1, orc2, orc3 ));
        
        //act
        
        exercito.atacarHorda( orcs );
        
        //assert
        assertEquals( 100.0, elfoVerde1.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde2.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde3.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde4.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde5.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde6.getVida(), 0.05 );
        assertEquals( 100.0, elfoVerde7.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno1.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno2.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno3.getVida(), 0.05 );
        
    }
    
    @Test
    public void estrategiaNoturnaEscendendoLimiteDeElfosNoturnos(){
        //arrange
        
        Elfo elfoNoturno1 = new ElfoNoturno("Night 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Night 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Night 3");
        Elfo elfoNoturno4 = new ElfoNoturno("Night 4");
        Elfo elfoNoturno5 = new ElfoNoturno("Night 5");
        Elfo elfoNoturno6 = new ElfoNoturno("Night 6");
        Elfo elfoNoturno7 = new ElfoNoturno("Night 7");
        Elfo elfoNoturno8 = new ElfoNoturno("Night 8");
        Elfo elfoNoturno9 = new ElfoNoturno("Night 9");
        Elfo elfoNoturno10 = new ElfoNoturno("Night 10");
        Orc orc1 = new Orc();
        Orc orc2 = new Orc();
        Orc orc3 = new Orc();
        
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        try{
            exercito.alistar(elfoNoturno1);
            exercito.alistar(elfoNoturno2);
            exercito.alistar(elfoNoturno3);
            exercito.alistar(elfoNoturno4);
            exercito.alistar(elfoNoturno5);
            exercito.alistar(elfoNoturno6);
            exercito.alistar(elfoNoturno7);
            exercito.alistar(elfoNoturno8);
            exercito.alistar(elfoNoturno9);
            exercito.alistar(elfoNoturno10);
        }catch( NaoPodeAlistarException erro ){
            System.out.println( erro );
        }
        ArrayList<Orc> orcs = new ArrayList<>( 
            Arrays.asList( orc1, orc2, orc3 ));
        
        //act
        
        exercito.atacarHorda( orcs );
        
        //assert
        assertEquals( 85.73, elfoNoturno1.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno2.getVida(), 0.05 );
        assertEquals( 100.0, elfoNoturno3.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno4.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno5.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno6.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno7.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno8.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno9.getVida(), 0.05 );
        assertEquals( 85.73, elfoNoturno10.getVida(), 0.05 );
        
    }

}
