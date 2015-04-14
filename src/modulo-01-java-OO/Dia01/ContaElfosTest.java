

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContaElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContaElfosTest
{
    @Test
    public void contarElfosVerdesComNenhumElfoNormalCriado(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        //act
        
        //assert
        assertEquals( 0, ContaElfos.getQuantidadeElfos() );
    }
    
    @Test
    public void contarElfosVerdesComUmElfoNormalCriado(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        Elfo elfo;
        //act
        elfo = new Elfo("cassiano");
        //assert
        assertEquals( 1, ContaElfos.getQuantidadeElfos() );
    }
    
    @Test
    public void contarElfosVerdesComCincoElfosNormaisCriados(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        Elfo elfo1;
        Elfo elfo2;
        Elfo elfo3;
        Elfo elfo4;
        Elfo elfo5;
        //act
        elfo1 = new Elfo("cassiano");
        elfo2 = new Elfo("cassiano");
        elfo3 = new Elfo("cassiano");
        elfo4 = new Elfo("cassiano");
        elfo5 = new Elfo("cassiano");
        
        //assert
        assertEquals( 5, ContaElfos.getQuantidadeElfos() );
    }
    
    @Test
    public void contarElfosComUmElfoVerdeCriado(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        ElfoVerde elfo;
        //act
        elfo = new ElfoVerde("cassiano");
        //assert
        assertEquals( 1, ContaElfos.getQuantidadeElfos() );
    }
    
    @Test
    public void contarElfosComCincoElfosVerdesCriados(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        ElfoVerde elfo1;
        ElfoVerde elfo2;
        ElfoVerde elfo3;
        ElfoVerde elfo4;
        ElfoVerde elfo5;
        //act
        elfo1 = new ElfoVerde("cassiano");
        elfo2 = new ElfoVerde("cassiano");
        elfo3 = new ElfoVerde("cassiano");
        elfo4 = new ElfoVerde("cassiano");
        elfo5 = new ElfoVerde("cassiano");
        //assert
        assertEquals( 5, ContaElfos.getQuantidadeElfos() );
    }
    
    @Test
    public void contarElfosVerdesComUmElfoNoturnoCriado(){
        //arrange
        ContaElfos.serQuantidadeElfos(0);
        ElfoNoturno elfo1;
        ElfoNoturno elfo2;
        ElfoNoturno elfo3;
        ElfoNoturno elfo4;
        ElfoNoturno elfo5;
        //act
        elfo1 = new ElfoNoturno("cassiano");
        elfo2 = new ElfoNoturno("cassiano");
        elfo3 = new ElfoNoturno("cassiano");
        elfo4 = new ElfoNoturno("cassiano");
        elfo5 = new ElfoNoturno("cassiano");
        //assert
        assertEquals( 5, ContaElfos.getQuantidadeElfos() );
    }
    
    
}
