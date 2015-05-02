
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BancoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BancoTest{

    @Test
    public void bancoRecebeConta(){
        //arrange
        Banco banco = new Banco();
        
        Conta conta = new ContaCorrente( "Corrente 1", 1291 );
        
        HashMap<String, Conta> esperado = new HashMap<>();
        esperado.put( conta.getNome(), conta );
        //act
        
        banco.adiciona( conta.getNome(), conta );
        //assert
        assertEquals( esperado.get("Corrente 1"), banco.buscarPorNome("Corrente 1"));
    }
}
