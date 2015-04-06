


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void nasceVariosOrcsCom110DeVida() {
        // Arrange - Montagem dos dados de teste
         Orc Orc1;
         Orc Orc2;
         Orc Orc3;
         Orc Orc4;
         Orc Orc5;
        // Act - Execução da ação de testes
        Orc1 = new Orc();
        Orc2 = new Orc();
        Orc3 = new Orc();
        Orc4 = new Orc();
        Orc5 = new Orc();
        // Assert - Verificação
        int esperado = 110;
        
        assertEquals(esperado, Orc1.getVida());
        assertEquals(esperado, Orc2.getVida());
        assertEquals(esperado, Orc3.getVida());
        assertEquals(esperado, Orc4.getVida());
        assertEquals(esperado, Orc5.getVida());
        
    }
        
    @Test
    public void orcRecebeAtaque() {
         // Arrange - Montagem dos dados de teste
         Orc umOrc;
         // Act - Execução da ação de testes
         umOrc = new Orc();
         int esperado = umOrc.getVida();
         umOrc.recebeAtaque();
         // Assert - Verificação
         esperado-= 10;
         int resultado = umOrc.getVida();
         
         assertEquals(esperado, resultado);
    }
    
    @Test
    public void orcRecebeVariosAtaques() {
         // Arrange - Montagem dos dados de teste
         Orc umOrc;
         // Act - Execução da ação de testes
         umOrc = new Orc();
         int esperado = umOrc.getVida();
         umOrc.recebeAtaque();
         esperado-= 10;
         umOrc.recebeAtaque();
         esperado-= 10;
         umOrc.recebeAtaque();
         esperado-= 10;
         umOrc.recebeAtaque();
         esperado-= 10;
         umOrc.recebeAtaque();
         esperado-= 10;
         umOrc.recebeAtaque();
         esperado-= 10;
         // Assert - Verificação
         int resultado = umOrc.getVida();
         
         assertEquals(esperado, resultado);
    }
    
    @Test
    public void variosOrcsRecebemUmAtaque(){
        // Arrange - Montagem dos dados de teste
        Orc Orc1;
        Orc Orc2;
        Orc Orc3;
        Orc Orc4;
        Orc Orc5;
        // Act - Execução da ação de testes
        Orc1 = new Orc();
        Orc2 = new Orc();
        Orc3 = new Orc();
        Orc4 = new Orc();
        Orc5 = new Orc();
        
        int esperado = 100;
        
        Orc1.recebeAtaque();
        Orc2.recebeAtaque();
        Orc3.recebeAtaque();
        Orc4.recebeAtaque();
        Orc5.recebeAtaque();
        
        // Assert - Verificação
        assertEquals(esperado, Orc1.getVida());
        assertEquals(esperado, Orc2.getVida());
        assertEquals(esperado, Orc3.getVida());
        assertEquals(esperado, Orc4.getVida());
        assertEquals(esperado, Orc5.getVida());
        
    }
    
    @Test
    public void variosOrcsRecebemVariosAtaques(){
        // Arrange - Montagem dos dados de teste
        Orc Orc1;
        Orc Orc2;
        Orc Orc3;
        Orc Orc4;
        Orc Orc5;
        // Act - Execução da ação de testes
        Orc1 = new Orc();
        Orc2 = new Orc();
        Orc3 = new Orc();
        Orc4 = new Orc();
        Orc5 = new Orc();
        
        int esperado = 80;
        
        Orc1.recebeAtaque();
        Orc1.recebeAtaque();
        Orc1.recebeAtaque();
        
        Orc2.recebeAtaque();
        Orc2.recebeAtaque();
        Orc2.recebeAtaque();
        
        Orc3.recebeAtaque();
        Orc3.recebeAtaque();
        Orc3.recebeAtaque();
        
        Orc4.recebeAtaque();
        Orc4.recebeAtaque();
        Orc4.recebeAtaque();
        
        Orc5.recebeAtaque();
        Orc5.recebeAtaque();
        Orc5.recebeAtaque();
        
        // Assert - Verificação
        assertEquals(esperado, Orc1.getVida());
        assertEquals(esperado, Orc2.getVida());
        assertEquals(esperado, Orc3.getVida());
        assertEquals(esperado, Orc4.getVida());
        assertEquals(esperado, Orc5.getVida());
        
    }
}





