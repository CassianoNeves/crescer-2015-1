
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void retornoToStringDeUmElfo(){
        //Arrange
        Elfo elfo = new Elfo("cassiano");
        //Act
        String resutadoObtido = elfo.toString();
        //Assert
        String esperado = "cassiano possui 42 flechas e 0 níveis de experiência.";
        
        assertEquals(esperado, resutadoObtido);
    }
    
    @Test
    public void retornoToStringDeDoisElfos(){
        //Arrange
        Elfo elfo1 = new Elfo("cassiano");
        Elfo elfo2 = new Elfo("joao");
        //Act
        String resutadoObtidoElfo1 = elfo1.toString();
        String resutadoObtidoElfo2 = elfo2.toString();
        
        //Assert
        String esperadoDoElfo1 = "cassiano possui 42 flechas e 0 níveis de experiência.";
        String esperadoDoElfo2 = "joao possui 42 flechas e 0 níveis de experiência.";
        
        assertEquals(esperadoDoElfo1, resutadoObtidoElfo1);
        assertEquals(esperadoDoElfo2, resutadoObtidoElfo2);
    }
    
    @Test
    public void criarUmElfoIncrementaQtdElfos() {
        // Arrange
        int esperado = 1;
        // Act
        Elfo elfo = new Elfo("Faustão");
        // Assert
        assertEquals(esperado, Elfo.getQuantidadeElfos());
    }
    
    @Test
    public void criarDoisElfosIncrementaQtdElfos() {
        // Arrange
        int esperado = 2;
        // Act
        new Elfo("Faustão");
        new Elfo("Faustão II");
        // Assert
        assertEquals(esperado, Elfo.getQuantidadeElfos());
    }
    
    @Test
    public void criarTresElfosIncrementaQtdElfos() {
        // Arrange
        int esperado = 3;
        // Act
        new Elfo("Faustão");
        new Elfo("Faustão II");
        new Elfo("Faustão III");
        // Assert
        assertEquals(esperado, Elfo.getQuantidadeElfos());
    }
    
    @Before
    public void setUp() {
        Elfo.resetarQuantidadeElfos();
    }
}

