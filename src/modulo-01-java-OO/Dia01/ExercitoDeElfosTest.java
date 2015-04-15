
import java.util.HashMap;
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
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoSemSoldados(){
        //arrange
        ExercitoDeElfos exercito;
        //act
        exercito = new ExercitoDeElfos();
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        
        assertEquals( resutadoEsperado, exercito.getAlistados() );
    }
    
    @Test
    public void elfosNormaisNaoPodeSerAlistado(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new Elfo("cassiano");
        Elfo elfo2 = new Elfo("joao");
        Elfo elfo3 = new Elfo("mario");
        //act
        exercito.alistarElfo( elfo1 );
        exercito.alistarElfo( elfo2 );
        exercito.alistarElfo( elfo3 );
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        
        assertEquals( resutadoEsperado, exercito.getAlistados() );
    }
    
    @Test
    public void alistandoElfoVerdeENoturnoAoExercito(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ElfoNoturno elfoNoturno = new ElfoNoturno("joao");
        //act
        exercito.alistarElfo( elfoVerde );
        exercito.alistarElfo( elfoNoturno );
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        resutadoEsperado.put(elfoVerde.getNome(), elfoVerde );
        resutadoEsperado.put(elfoNoturno.getNome(), elfoNoturno);
        
        assertEquals( resutadoEsperado, exercito.getAlistados() );
    }
    
    @Test
    public void alistandovariosElfosVerdesENoturnosAoExercito(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde1 = new ElfoVerde("cassiano");
        ElfoVerde elfoVerde2 = new ElfoVerde("maria");
        ElfoVerde elfoVerde3 = new ElfoVerde("luiz");
        ElfoVerde elfoVerde4 = new ElfoVerde("batista");
        ElfoVerde elfoVerde5 = new ElfoVerde("zeh");
        ElfoNoturno elfoNoturno1 = new ElfoNoturno("joao");
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("francisco");
        ElfoNoturno elfoNoturno3 = new ElfoNoturno("beto");
        ElfoNoturno elfoNoturno4 = new ElfoNoturno("ronaldo");
        ElfoNoturno elfoNoturno5 = new ElfoNoturno("mario");
        //act
        exercito.alistarElfo( elfoVerde1 );
        exercito.alistarElfo( elfoNoturno1 );
        exercito.alistarElfo( elfoVerde2 );
        exercito.alistarElfo( elfoNoturno2 );
        exercito.alistarElfo( elfoVerde3 );
        exercito.alistarElfo( elfoNoturno3 );
        exercito.alistarElfo( elfoVerde4 );
        exercito.alistarElfo( elfoNoturno4 );
        exercito.alistarElfo( elfoVerde5 );
        exercito.alistarElfo( elfoNoturno5 );
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        resutadoEsperado.put(elfoVerde1.getNome(), elfoVerde1 );
        resutadoEsperado.put(elfoNoturno1.getNome(), elfoNoturno1 );
        resutadoEsperado.put(elfoVerde2.getNome(), elfoVerde2 );
        resutadoEsperado.put(elfoNoturno2.getNome(), elfoNoturno2 );
        resutadoEsperado.put(elfoVerde3.getNome(), elfoVerde3 );
        resutadoEsperado.put(elfoNoturno3.getNome(), elfoNoturno3 );
        resutadoEsperado.put(elfoVerde4.getNome(), elfoVerde4 );
        resutadoEsperado.put(elfoNoturno4.getNome(), elfoNoturno4 );
        resutadoEsperado.put(elfoVerde5.getNome(), elfoVerde5 );
        resutadoEsperado.put(elfoNoturno5.getNome(), elfoNoturno5 );
        
        assertEquals( resutadoEsperado, exercito.getAlistados() );
    }
    
    @Test
    public void obetendoElfosDoExercitoPeloNome(){
         //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ElfoNoturno elfoNoturno = new ElfoNoturno("joao");
        //act
        exercito.alistarElfo( elfoVerde );
        exercito.alistarElfo( elfoNoturno );
        //assert
        
        assertEquals( elfoVerde, exercito.getElfo( elfoVerde.getNome() ) );
        assertEquals( elfoNoturno, exercito.getElfo( elfoNoturno.getNome() ) );
    }
    
    @Test
    public void obetendoElfosDoExercitoPeloNomeComVariosSoldadosMisturados(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde1 = new ElfoVerde("cassiano");
        ElfoVerde elfoVerde2 = new ElfoVerde("maria");
        ElfoVerde elfoVerde3 = new ElfoVerde("luiz");
        ElfoVerde elfoVerde4 = new ElfoVerde("batista");
        ElfoVerde elfoVerde5 = new ElfoVerde("zeh");
        ElfoNoturno elfoNoturno1 = new ElfoNoturno("joao");
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("francisco");
        ElfoNoturno elfoNoturno3 = new ElfoNoturno("beto");
        ElfoNoturno elfoNoturno4 = new ElfoNoturno("ronaldo");
        ElfoNoturno elfoNoturno5 = new ElfoNoturno("mario");
        //act
        exercito.alistarElfo( elfoVerde1 );
        exercito.alistarElfo( elfoNoturno1 );
        exercito.alistarElfo( elfoVerde2 );
        exercito.alistarElfo( elfoNoturno2 );
        exercito.alistarElfo( elfoVerde3 );
        exercito.alistarElfo( elfoNoturno3 );
        exercito.alistarElfo( elfoVerde4 );
        exercito.alistarElfo( elfoNoturno4 );
        exercito.alistarElfo( elfoVerde5 );
        exercito.alistarElfo( elfoNoturno5 );
        //assert
        assertEquals( elfoVerde1, exercito.getElfo( elfoVerde1.getNome() ) );
        assertEquals( elfoNoturno1, exercito.getElfo( elfoNoturno1.getNome() ) );
        assertEquals( elfoVerde2, exercito.getElfo( elfoVerde2.getNome() ) );
        assertEquals( elfoNoturno2, exercito.getElfo( elfoNoturno2.getNome() ) );
        assertEquals( elfoVerde3, exercito.getElfo( elfoVerde3.getNome() ) );
        assertEquals( elfoNoturno3, exercito.getElfo( elfoNoturno3.getNome() ) );
        assertEquals( elfoVerde4, exercito.getElfo( elfoVerde4.getNome() ) );
        assertEquals( elfoNoturno4, exercito.getElfo( elfoNoturno4.getNome() ) );
        assertEquals( elfoVerde5, exercito.getElfo( elfoVerde5.getNome() ) );
        assertEquals( elfoNoturno5, exercito.getElfo( elfoNoturno5.getNome() ) );
    }
    
    @Test
    public void obetendoElfosDoExercitoPorStatusMorto(){
         //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ElfoNoturno elfoNoturno = new ElfoNoturno("joao");
        //act
        exercito.alistarElfo( elfoVerde );
        exercito.alistarElfo( elfoNoturno );
        elfoVerde.setStatus( Status.MORTO );
        
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        resutadoEsperado.put(elfoVerde.getNome(), elfoVerde );
        
        assertEquals( resutadoEsperado, exercito.getElfosPorStatus( Status.MORTO ) );
    }
    
    @Test
    public void obetendoVariosElfosDoExercitoPorStatusMorto(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde1 = new ElfoVerde("cassiano");
        ElfoVerde elfoVerde2 = new ElfoVerde("maria");
        ElfoVerde elfoVerde3 = new ElfoVerde("luiz");
        ElfoVerde elfoVerde4 = new ElfoVerde("batista");
        ElfoVerde elfoVerde5 = new ElfoVerde("zeh");
        ElfoNoturno elfoNoturno1 = new ElfoNoturno("joao");
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("francisco");
        ElfoNoturno elfoNoturno3 = new ElfoNoturno("beto");
        ElfoNoturno elfoNoturno4 = new ElfoNoturno("ronaldo");
        ElfoNoturno elfoNoturno5 = new ElfoNoturno("mario");
        //act
        exercito.alistarElfo( elfoVerde1 );
        exercito.alistarElfo( elfoNoturno1 );
        exercito.alistarElfo( elfoVerde2 );
        exercito.alistarElfo( elfoNoturno2 );
        exercito.alistarElfo( elfoVerde3 );
        exercito.alistarElfo( elfoNoturno3 );
        exercito.alistarElfo( elfoVerde4 );
        exercito.alistarElfo( elfoNoturno4 );
        exercito.alistarElfo( elfoVerde5 );
        exercito.alistarElfo( elfoNoturno5 );
        
        elfoVerde2.setStatus( Status.MORTO );
        elfoVerde4.setStatus( Status.MORTO );
        elfoNoturno1.setStatus( Status.MORTO );
        elfoNoturno3.setStatus( Status.MORTO );
        
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        resutadoEsperado.put( elfoVerde2.getNome(), elfoVerde2 );
        resutadoEsperado.put( elfoVerde4.getNome(), elfoVerde4 );
        resutadoEsperado.put( elfoNoturno1.getNome(), elfoNoturno1 );
        resutadoEsperado.put( elfoNoturno3.getNome(), elfoNoturno3 );
        
        assertEquals( resutadoEsperado, exercito.getElfosPorStatus( Status.MORTO ) );
    }
    
    @Test
    public void obetendoVariosElfosDoExercitoPorStatusFerido(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde1 = new ElfoVerde("cassiano");
        ElfoVerde elfoVerde2 = new ElfoVerde("maria");
        ElfoVerde elfoVerde3 = new ElfoVerde("luiz");
        ElfoVerde elfoVerde4 = new ElfoVerde("batista");
        ElfoVerde elfoVerde5 = new ElfoVerde("zeh");
        ElfoNoturno elfoNoturno1 = new ElfoNoturno("joao");
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("francisco");
        ElfoNoturno elfoNoturno3 = new ElfoNoturno("beto");
        ElfoNoturno elfoNoturno4 = new ElfoNoturno("ronaldo");
        ElfoNoturno elfoNoturno5 = new ElfoNoturno("mario");
        //act
        exercito.alistarElfo( elfoVerde1 );
        exercito.alistarElfo( elfoNoturno1 );
        exercito.alistarElfo( elfoVerde2 );
        exercito.alistarElfo( elfoNoturno2 );
        exercito.alistarElfo( elfoVerde3 );
        exercito.alistarElfo( elfoNoturno3 );
        exercito.alistarElfo( elfoVerde4 );
        exercito.alistarElfo( elfoNoturno4 );
        exercito.alistarElfo( elfoVerde5 );
        exercito.alistarElfo( elfoNoturno5 );
        
        elfoVerde2.setStatus( Status.FERIDO );
        elfoVerde4.setStatus( Status.FERIDO );
        elfoNoturno1.setStatus( Status.FERIDO );
        elfoNoturno3.setStatus( Status.FERIDO );
        
        //assert
        HashMap<String, Elfo> resutadoEsperado = new HashMap<>();
        resutadoEsperado.put( elfoVerde2.getNome(), elfoVerde2 );
        resutadoEsperado.put( elfoVerde4.getNome(), elfoVerde4 );
        resutadoEsperado.put( elfoNoturno1.getNome(), elfoNoturno1 );
        resutadoEsperado.put( elfoNoturno3.getNome(), elfoNoturno3 );
        
        assertEquals( resutadoEsperado, exercito.getElfosPorStatus( Status.FERIDO ) );
    }
}
