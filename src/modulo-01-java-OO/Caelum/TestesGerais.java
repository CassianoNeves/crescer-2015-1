
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestesGerais.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestesGerais{

    @Test
    public void testeComCollectionsSort(){
        List<String> lista = new ArrayList<>();
        lista.add("Sérgio");
        lista.add("Paulo");
        lista.add("Guilherme");
        
        // repare que o toString de ArrayList foi sobrescrito:
        System.out.println(lista);
        
        Collections.sort(lista);
        
        System.out.println(lista);
    }
    
    public void testandoCollectionsSortComObjetos(){
        ContaCorrente c1 = new ContaCorrente(1);
        c1.deposita(500);
        
        ContaCorrente c2 = new ContaCorrente(12);
        c2.deposita(200);
        
        ContaCorrente c3 = new ContaCorrente(123);
        c3.deposita(150);
        
        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(c1);
        contas.add(c3);
        contas.add(c2);
    }
    
    public void testaOMetodoCompareToDaContaCorrente(){
        ContaCorrente c1 = new ContaCorrente(123);
        c1.deposita(500);
        
        ContaCorrente c2 = new ContaCorrente(1234);
        c2.deposita(200);
        
        int valor = c1.compareTo(c2);
        
        assertEquals( 1, valor );
    }
}
