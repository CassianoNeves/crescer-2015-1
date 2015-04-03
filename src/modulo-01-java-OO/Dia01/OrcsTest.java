

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcsTest
{
    @Test
    public void orcNasceCom110Vida(){
       
        //Arrange - Montagem de dos dados de teste
        Orcs umOrc;
        //Acao - Execução da ação de testes
        umOrc = new Orcs("joao");
        //Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(resultadoObtido, esperado);
    }
    
}
