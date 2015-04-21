
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaIntercaladaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaIntercaladaTest{
    
    @Test
    public void exercitoComAtaqueIntercaldoComElfoVerdeComecandoOAtaque(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaIntercalada() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoVerde2, elfoNoturno1, elfoVerde1, elfoNoturno2 ) );
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getUltimaOrdemDeAtaque() );
    }
    
    @Test
    public void exercitoComAtaqueIntercaldoComElfoNoturnoComecandoOAtaque(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaIntercalada() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoNoturno1 = new ElfoNoturno("Elfo Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoNoturno1, elfoVerde2, elfoNoturno2, elfoVerde1) );
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getUltimaOrdemDeAtaque() );
    }
    
    @Test
    public void exercitoDespropocionalNaoPodeAtacar(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaIntercalada() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>();
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getUltimaOrdemDeAtaque() );
    }

}
