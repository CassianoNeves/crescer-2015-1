
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContaPoupancaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContaPoupancaTest{
    
    @Test
    public void testaOrdenacao(){
        //arrange
        List<ContaPoupanca> contas = new ArrayList<>();
    
        ContaPoupanca c1 = new ContaPoupanca(1973);
        contas.add(c1);
    
        ContaPoupanca c2 = new ContaPoupanca(1462);
        contas.add(c2);
    
        ContaPoupanca c3 = new ContaPoupanca(1854);
        contas.add(c3);
        
        List<ContaPoupanca> esperado = new ArrayList<>();
        esperado.add(c2);
        esperado.add(c3);
        esperado.add(c1);
        //act
        Collections.sort(contas);
        //assert
        assertEquals( esperado, contas );
        
       for (int i = 0; i < contas.size(); i++) {
           System.out.println("numero: " + contas.get(i).getNumero());
        }
        
    }
    
}
