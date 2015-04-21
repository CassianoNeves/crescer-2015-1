
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest{
    
    @Test
    public void exercitoNaoPodeAlistarElfoNormal(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo = new Elfo("Elfo");
        HashMap<String, Elfo> resultadoEsperado = new HashMap<>();
        //act
        exercito.alistar( elfo );
        //assert
        assertEquals( resultadoEsperado, exercito.getExercito() );
    }

    @Test
    public void exercitoAlistandoElfosVerderENoturnos(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde = new ElfoVerde("Verde");
        Elfo elfoNoturno = new ElfoNoturno("Noturno");
        HashMap<String, Elfo> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put( elfoVerde.getNome(), elfoVerde );
        resultadoEsperado.put( elfoNoturno.getNome(), elfoNoturno );
        //act
        exercito.alistar( elfoVerde );
        exercito.alistar( elfoNoturno );
        //assert
        assertEquals( resultadoEsperado, exercito.getExercito() );
    }
    
    @Test
    public void exercitoAlistandoVariosElfosVerderENoturnosEBarrandoElfosNormais(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde1 = new ElfoVerde("Verde1");
        Elfo elfoVerde2 = new ElfoVerde("Verde2");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno2");
        Elfo elfoNormal1= new Elfo("Normal1");
        Elfo elfoNormal2= new Elfo("Normal2");
        HashMap<String, Elfo> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put( elfoVerde1.getNome(), elfoVerde1 );
        resultadoEsperado.put( elfoVerde2.getNome(), elfoVerde2 );
        resultadoEsperado.put( elfoNoturno1.getNome(), elfoNoturno1 );
        resultadoEsperado.put( elfoNoturno2.getNome(), elfoNoturno2 );
        //act
        exercito.alistar( elfoVerde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoNormal1 );
        exercito.alistar( elfoNormal2 );
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        //assert
        assertEquals( resultadoEsperado, exercito.getExercito() );
    }
    
    @Test
    public void buscandoElfoPeloNome(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo = new ElfoVerde("Verde");
        //act
        exercito.alistar( elfo );
        //assert
        assertEquals( elfo, exercito.buscar( elfo.getNome() ) );
    }
    
    @Test
    public void buscandoElfosVerdeENoturnosPeloNome(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoverde1 = new ElfoVerde("Verde1");
        Elfo elfoVerde2 = new ElfoVerde("Verde2");
        Elfo elfoNoturno1 = new ElfoNoturno("Noturno1");
        Elfo elfoNoturno2 = new ElfoNoturno("Noturno2");
        //act
        exercito.alistar( elfoverde1 );
        exercito.alistar( elfoVerde2 );
        exercito.alistar( elfoNoturno1 );
        exercito.alistar( elfoNoturno2 );
        //assert
        assertEquals( elfoverde1, exercito.buscar( elfoverde1.getNome() ) );
        assertEquals( elfoVerde2, exercito.buscar( elfoVerde2.getNome() ) );
        assertEquals( elfoNoturno1, exercito.buscar( elfoNoturno1.getNome() ) );
        assertEquals( elfoNoturno2, exercito.buscar( elfoNoturno2.getNome() ) );
    }
}
