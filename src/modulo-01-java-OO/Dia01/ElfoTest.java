

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void umElfoNasceCom42Flechas(){
        // Arrange - Montagem dos dados de teste
        Elfo umElfo;
        // Act - Execução da ação de testes
        int esperado = 42;
        umElfo = new Elfo("cassiano");
        // Assert - Verificação

        assertEquals(esperado, umElfo.getFlechas());
       
    }
    
     @Test
    public void umElfoNasceQtdDeFlechas(){
        // Arrange - Montagem dos dados de teste
        Elfo umElfo;
        // Act - Execução da ação de testes
        int esperado = 50;
        umElfo = new Elfo("cassiano", 50);
        // Assert - Verificação

        assertEquals(esperado, umElfo.getFlechas());
       
    }
    
     @Test
    public void variosElfosNascemComAQtdDeFlechas(){
        Elfo Elfo1;
        Elfo Elfo2;
        Elfo Elfo3;
        Elfo Elfo4;
        Elfo Elfo5;
        // Act - Execução da ação de testes
        int esperado = 50;
        Elfo1 = new Elfo("cassiano", 50);
        Elfo2 = new Elfo("joao", 50);
        Elfo3 = new Elfo("rosa", 50);
        Elfo4 = new Elfo("maria", 50);
        Elfo5 = new Elfo("pedro", 50);
        // Assert - Verificação

        assertEquals(esperado, Elfo1.getFlechas());
        assertEquals(esperado, Elfo2.getFlechas());
        assertEquals(esperado, Elfo3.getFlechas());
        assertEquals(esperado, Elfo4.getFlechas());
        assertEquals(esperado, Elfo5.getFlechas());
       
    }
    
    @Test
    public void umElfoNasceComNome(){
        // Arrange - Montagem dos dados de teste
        Elfo umElfo;
        // Act - Execução da ação de testes
        String esperado = "cassiano";
        umElfo = new Elfo("cassiano");
        // Assert - Verificação

        assertEquals(esperado, umElfo.getNome());
       
    }
    
    @Test
    public void variosElfosNascemComNome(){
        // Arrange - Montagem dos dados de teste
        Elfo Elfo1;
        Elfo Elfo2;
        Elfo Elfo3;
        Elfo Elfo4;
        Elfo Elfo5;
        // Act - Execução da ação de testes
        Elfo1 = new Elfo("cassiano");
        Elfo2 = new Elfo("joao");
        Elfo3 = new Elfo("rosa");
        Elfo4 = new Elfo("maria");
        Elfo5 = new Elfo("pedro");
       
        String nome1 = "cassiano";
        String nome2 = "joao";
        String nome3 = "rosa";
        String nome4 = "maria";
        String nome5 = "pedro";
        // Assert - Verificação

        assertEquals(nome1, Elfo1.getNome());
        assertEquals(nome2, Elfo2.getNome());
        assertEquals(nome3, Elfo3.getNome());
        assertEquals(nome4, Elfo4.getNome());
        assertEquals(nome5, Elfo5.getNome());
       
    }
    
    @Test
    public void umElfoAtiraFlechaEmUmOrc(){
        // Arrange - Montagem dos dados de teste
        Elfo umElfo;
        Orc umOrc;
        // Act - Execução da ação de testes
        int experienciaEsperadoDoElfo = 1;
        int flechasEsperadasDoElfo = 49;
        int vidaEsperadoDoOrc = 100;
        
        umElfo = new Elfo("cassiano", 50);
        umOrc = new Orc();
        
        umElfo.atirarFlecha(umOrc);
        // Assert - Verificação
        assertEquals(experienciaEsperadoDoElfo, umElfo.getExperiencia());
        assertEquals(flechasEsperadasDoElfo, umElfo.getFlechas());
        assertEquals(vidaEsperadoDoOrc, umOrc.getVida());
    }
    
    @Test
    public void umElfoAtiraFlechasEmvariosOrcs(){
        // Arrange - Montagem dos dados de teste
        Elfo umElfo;
        
        Orc Orc1;
        Orc Orc2;
        Orc Orc3;
        Orc Orc4;
        Orc Orc5;
        // Act - Execução da ação de testes
        int experienciaEsperadoDoElfo = 5;
        int flechasEsperadasDoElfo = 45;
        int vidaEsperadoDoOrc = 100;
        
        umElfo = new Elfo("cassiano", 50);
       
        Orc1 = new Orc();
        Orc2 = new Orc();
        Orc3 = new Orc();
        Orc4 = new Orc();
        Orc5 = new Orc();
        
        umElfo.atirarFlecha(Orc1);
        umElfo.atirarFlecha(Orc2);
        umElfo.atirarFlecha(Orc3);
        umElfo.atirarFlecha(Orc4);
        umElfo.atirarFlecha(Orc5);
        // Assert - Verificação
        assertEquals(experienciaEsperadoDoElfo, umElfo.getExperiencia());
        assertEquals(flechasEsperadasDoElfo, umElfo.getFlechas());
        assertEquals(vidaEsperadoDoOrc, Orc1.getVida());
        assertEquals(vidaEsperadoDoOrc, Orc2.getVida());
        assertEquals(vidaEsperadoDoOrc, Orc3.getVida());
        assertEquals(vidaEsperadoDoOrc, Orc4.getVida());
        assertEquals(vidaEsperadoDoOrc, Orc5.getVida());
    }
    
    @Test
    public void variosElfosAtiraFlechasEmUmOrc(){
        // Arrange - Montagem dos dados de teste
        Elfo Elfo1;
        Elfo Elfo2;
        Elfo Elfo3;
        Elfo Elfo4;
        Elfo Elfo5;
        
        Orc umOrc;
        // Act - Execução da ação de testes
        int experienciaEsperadoDoElfo = 1;
        int flechasEsperadasDoElfo = 49;
        int vidaEsperadoDoOrc = 60;
        
        Elfo1 = new Elfo("cassiano", 50);
        Elfo2 = new Elfo("pedro", 50);
        Elfo3 = new Elfo("joao", 50);
        Elfo4 = new Elfo("luiz", 50);
        Elfo5 = new Elfo("maria", 50);
       
        umOrc = new Orc();

        Elfo1.atirarFlecha(umOrc);
        Elfo2.atirarFlecha(umOrc);
        Elfo3.atirarFlecha(umOrc);
        Elfo4.atirarFlecha(umOrc);
        Elfo5.atirarFlecha(umOrc);
       
        // Assert - Verificação
        assertEquals(experienciaEsperadoDoElfo, Elfo1.getExperiencia());
        assertEquals(experienciaEsperadoDoElfo, Elfo2.getExperiencia());
        assertEquals(experienciaEsperadoDoElfo, Elfo3.getExperiencia());
        assertEquals(experienciaEsperadoDoElfo, Elfo4.getExperiencia());
        assertEquals(experienciaEsperadoDoElfo, Elfo5.getExperiencia());
        
        assertEquals(flechasEsperadasDoElfo, Elfo1.getFlechas());
        assertEquals(flechasEsperadasDoElfo, Elfo2.getFlechas());
        assertEquals(flechasEsperadasDoElfo, Elfo3.getFlechas());
        assertEquals(flechasEsperadasDoElfo, Elfo4.getFlechas());
        assertEquals(flechasEsperadasDoElfo, Elfo5.getFlechas());
        
        assertEquals(vidaEsperadoDoOrc, umOrc.getVida());

    }
    

   
}
