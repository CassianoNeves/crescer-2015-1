

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class EstrategiaElfosVerdesAtacamPrimeiroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaElfosVerdesAtacamPrimeiroTest{
    
    @Test
    public void garantirAOrdenacaoDoExercito(){
        //arrange
        EstrategiaElfosVerdesAtacamPrimeiro estrategia = new EstrategiaElfosVerdesAtacamPrimeiro();
        
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoVerde4 = new ElfoVerde("Verde 4");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        Elfo elfoVerde5 = new ElfoVerde("Verde 5");
        Elfo elfoVerde6 = new ElfoVerde("Verde 6");
        Elfo elfoVerde7 = new ElfoVerde("Verde 7");
        ArrayList<Elfo> elfos = new ArrayList<Elfo>( 
        Arrays.asList( elfoNoturno1, elfoNoturno2, elfoNoturno3,
        elfoVerde1, elfoVerde2, elfoVerde3, elfoVerde4, elfoVerde5,
        elfoVerde6, elfoVerde7));
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<Elfo>( 
        Arrays.asList( elfoVerde1, elfoVerde2, elfoVerde3,
        elfoVerde4, elfoVerde5, elfoVerde6, elfoVerde7, elfoNoturno1,
        elfoNoturno2, elfoNoturno3));
        //act
        estrategia.ordernarElfos( elfos );
        //assert
        assertEquals( resultadoEsperado, elfos );
    }
    
    @Test
    public void ordernarAtaqueComPrioridadeDeElfosVerdes() throws NaoPodeAlistarException{
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaElfosVerdesAtacamPrimeiro());
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno 1");
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno 2");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoVerde4 = new ElfoVerde("Verde 4");
        Elfo elfoNoturno3 = new ElfoNoturno("Noturno 3");
        Elfo elfoVerde5 = new ElfoVerde("Verde 5");
        Elfo elfoVerde6 = new ElfoVerde("Verde 6");
        Elfo elfoVerde7 = new ElfoVerde("Verde 7");
        
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoNoturno2 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.alistar( elfoVerde4 );
        exercito.alistar( elfoNoturno3 );
        exercito.alistar( elfoVerde5 );
        exercito.alistar( elfoVerde6 );
        exercito.alistar( elfoVerde7 );
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<Elfo>( 
        Arrays.asList( elfoVerde6, elfoVerde7, elfoVerde4,
        elfoVerde5, elfoVerde2, elfoVerde3, elfoVerde1, elfoNoturno3,
        elfoNoturno1, elfoNoturno2));
        //act
        
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc() ) ) );
            
        //assert
        assertEquals( resultadoEsperado, exercito.getOrdemDoUltimoAtaque() );
    }
    
    @Test
    public void ataqueSemElfosNoturnos() throws NaoPodeAlistarException{
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaElfosVerdesAtacamPrimeiro());
        Elfo elfoVerde1 = new ElfoVerde("Verde 1");
        Elfo elfoVerde2 = new ElfoVerde("Verde 2");
        Elfo elfoVerde3 = new ElfoVerde("Verde 3");
        Elfo elfoVerde4 = new ElfoVerde("Verde 4");
        Elfo elfoVerde5 = new ElfoVerde("Verde 5");
        Elfo elfoVerde6 = new ElfoVerde("Verde 6");
        Elfo elfoVerde7 = new ElfoVerde("Verde 7");
        
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoVerde3 );
        exercito.alistar( elfoVerde4 );
        exercito.alistar( elfoVerde5 );
        exercito.alistar( elfoVerde6 );
        exercito.alistar( elfoVerde7 );
        
        ArrayList<Elfo> resultadoEsperado = new ArrayList<Elfo>( 
        Arrays.asList( elfoVerde6, elfoVerde7, elfoVerde4,
        elfoVerde5, elfoVerde2, elfoVerde3, elfoVerde1));
        //act
        
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc() ) ) );
            
        //assert
        assertEquals( resultadoEsperado, exercito.getOrdemDoUltimoAtaque() );
    }
    

}
