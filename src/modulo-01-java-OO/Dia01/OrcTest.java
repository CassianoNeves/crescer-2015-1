import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);

    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("cassiano");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void adicionadoItemAoOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        //act
        orc.addItemParaOrc(machado);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<ItemDoInventario>();
        resultadoEsperado.add(machado);
        
        assertEquals(resultadoEsperado, orc.getItens());
    }
    
    @Test
    public void umOrcSemItens(){
        //arrange
        Orc orc = new Orc("cassiano");
        //act
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<ItemDoInventario>();
        //assert
      
        assertEquals(resultadoEsperado, orc.getItens());
    }
}




