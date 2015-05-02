
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContaTest{

    @Test
    public void testandoHashSetComContas(){
        //arrange
        Set<Conta> contas = new HashSet<>();
        Conta conta1 = new Conta("conta", 1234);
        Conta conta2 = new Conta("conta1", 1234);
        //act
        contas.add(conta1);
        contas.add(conta2);
        //assert
        
        assertEquals( 1, contas.size() );
    }
    
}
