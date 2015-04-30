
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContaSalarioTest.
 *
 * @author  Cassiano das Neves
 * @version (a version number or a date)
 */
public class ContaSalarioTest{

    @Test
    public void ordenandoListaPeloNomeDoClienteEmOrdemAlfabetica(){
        //arrange
        List<ContaSalario> contas = new ArrayList<>();
        
        ContaSalario c1 = new ContaSalario(1973, "Joao");
        contas.add(c1);
    
        ContaSalario c2 = new ContaSalario(1462, "Cassio");
        contas.add(c2);
    
        ContaSalario c3 = new ContaSalario(1854, "Maria");
        contas.add(c3);
        
        List<ContaSalario> esperado = new ArrayList<>();
        esperado.add(c2);
        esperado.add(c1);
        esperado.add(c3);
        //act
        Collections.sort( contas );
        //assert
        assertEquals( esperado, contas );
    }
}
