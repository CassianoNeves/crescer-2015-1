
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
    public void garantirQueOExercitoEstaIntercalado() throws NaoPodeAlistarException{
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia( new EstrategiaIntercalada() );
        ArrayList<Elfo> elfos = new ArrayList<>();
        
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        
        exercito.alistar(elfoVerde1);
        exercito.alistar(elfoVerde2);
        exercito.alistar(elfoVerde3);
        exercito.alistar(elfoNoturno1);
        exercito.alistar(elfoNoturno2);
        exercito.alistar(elfoNoturno3);
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoNoturno3, elfoVerde2, elfoNoturno1, elfoVerde3, elfoNoturno2, elfoVerde1 ));
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ));
            
        //act
        exercito.atacarHorda( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getOrdemDoUltimoAtaque() );
        
    }
    
    @Test
    public void garantirQueOExercitoEstaIntercaladoComOrdeminvertida() throws NaoPodeAlistarException{
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia( new EstrategiaIntercalada() );
        ArrayList<Elfo> elfos = new ArrayList<>();
        
        Elfo elfoVerde1 = new ElfoVerde("Elfo Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        
        exercito.alistar(elfoNoturno1);
        exercito.alistar(elfoNoturno2);
        exercito.alistar(elfoNoturno3);
        exercito.alistar(elfoVerde1);
        exercito.alistar(elfoVerde2);
        exercito.alistar(elfoVerde3);

        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>(
            Arrays.asList( elfoVerde1, elfoNoturno3, elfoVerde3, elfoNoturno1, elfoVerde2, elfoNoturno2 ));
        
        ArrayList<Orc> orcs = new ArrayList<>(
            Arrays.asList( new Orc(), new Orc(), new Orc() ));
            
        //act
        exercito.atacarHorda( orcs );
        //assert
        
        assertEquals( resultadoEsperado, exercito.getOrdemDoUltimoAtaque() );
        
    }
    
}
