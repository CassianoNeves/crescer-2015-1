
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ComparadorPorTamanhoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ComparadorPorTamanhoTest{

    @Test
    public void ordenandoListaDeStringPorTamanhoDaString(){
        //arrange
        
        List<String> lista = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        
        lista.add("Guilherme");
        lista.add("Sérgio");
        lista.add("Paulo");

        esperado.add("Paulo");
        esperado.add("Sérgio");
        esperado.add("Guilherme");
        
        ComparadorPorTamanho comparador = new ComparadorPorTamanho();
        //act
        Collections.sort(lista, comparador);
        //assert
        
        assertEquals( esperado, lista );
    }
    
    @Test
    public void ordenandoListaDeStringPorTamanhoDaStringComClasseAnonima(){
        //arrange
        
        List<String> lista = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        
        lista.add("Guilherme");
        lista.add("Sérgio");
        lista.add("Paulo");

        esperado.add("Paulo");
        esperado.add("Sérgio");
        esperado.add("Guilherme");
        
        Comparator<String> comparador = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        //act
        Collections.sort(lista, comparador);
        //assert
        
        assertEquals( esperado, lista );
    }
   
}
