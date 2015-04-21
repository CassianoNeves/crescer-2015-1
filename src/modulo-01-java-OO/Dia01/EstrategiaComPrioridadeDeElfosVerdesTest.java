
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaComPrioridadeDeElfosVerdesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaComPrioridadeDeElfosVerdesTest{
    
    @Test
    public void exercitoComPrioridadeDeAtaqueDosElfosVerdes(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaComPrioridadeDeElfosVerdes() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoVerde2, elfoVerde3, elfoVerde1, elfoNoturno1, elfoNoturno2 ) );
        
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
    
    @Test
    public void exercitoComApenasElfosVerdes(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaComPrioridadeDeElfosVerdes() );
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoVerde4 = new ElfoVerde("Verde 4");
        Elfo elfoVerde5 = new ElfoVerde("Verde 5");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoVerde4, elfoVerde5, elfoVerde2, elfoVerde3, elfoVerde1 ) );
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoVerde4 );
        exercito.alistar( elfoVerde5 );
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getUltimaOrdemDeAtaque() );
    }
    
    @Test
    public void exercitoComApenasElfosNoturnos(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.setEstrategiaDeAtaque( new EstrategiaComPrioridadeDeElfosVerdes() );
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        Elfo elfoNoturno4 = new ElfoNoturno("Noturno 4");
        Elfo elfoNoturno5 = new ElfoNoturno("Noturno 5");
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoNoturno5, elfoNoturno3, elfoNoturno4, elfoNoturno1, elfoNoturno2 ) );
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ) );
        //act
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoNoturno3 );
        exercito.alistar( elfoNoturno4 );
        exercito.alistar( elfoNoturno5 );
        exercito.atacarOrcs( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getUltimaOrdemDeAtaque() );
    }
}
